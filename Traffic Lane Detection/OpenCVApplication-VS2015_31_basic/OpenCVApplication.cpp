// OpenCVApplication.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "common.h"


void testOpenImage()
{
	char fname[MAX_PATH];
	while(openFileDlg(fname))
	{
		Mat src;
		src = imread(fname);
		imshow("image",src);
		waitKey();
	}
}

void testOpenImagesFld()
{
	char folderName[MAX_PATH];
	if (openFolderDlg(folderName)==0)
		return;
	char fname[MAX_PATH];
	FileGetter fg(folderName,"bmp");
	while(fg.getNextAbsFile(fname))
	{
		Mat src;
		src = imread(fname);
		imshow(fg.getFoundFileName(),src);
		if (waitKey()==27) //ESC pressed
			break;
	}
}

void testImageOpenAndSave()
{
	Mat src, dst;

	src = imread("Images/Lena_24bits.bmp", CV_LOAD_IMAGE_COLOR);	// Read the image

	if (!src.data)	// Check for invalid input
	{
		printf("Could not open or find the image\n");
		return;
	}

	// Get the image resolution
	Size src_size = Size(src.cols, src.rows);

	// Display window
	const char* WIN_SRC = "Src"; //window for the source image
	namedWindow(WIN_SRC, CV_WINDOW_AUTOSIZE);
	cvMoveWindow(WIN_SRC, 0, 0);

	const char* WIN_DST = "Dst"; //window for the destination (processed) image
	namedWindow(WIN_DST, CV_WINDOW_AUTOSIZE);
	cvMoveWindow(WIN_DST, src_size.width + 10, 0);

	cvtColor(src, dst, CV_BGR2GRAY); //converts the source image to a grayscale one

	imwrite("Images/Lena_24bits_gray.bmp", dst); //writes the destination to file

	imshow(WIN_SRC, src);
	imshow(WIN_DST, dst);

	printf("Press any key to continue ...\n");
	waitKey(0);
}

void testNegativeImage()
{
	char fname[MAX_PATH];
	while(openFileDlg(fname))
	{
		double t = (double)getTickCount(); // Get the current time [s]
		
		Mat src = imread(fname,CV_LOAD_IMAGE_GRAYSCALE);
		int height = src.rows;
		int width = src.cols;
		Mat dst = Mat(height,width,CV_8UC1);
		// Asa se acceseaaza pixelii individuali pt. o imagine cu 8 biti/pixel
		// Varianta ineficienta (lenta)
		for (int i=0; i<height; i++)
		{
			for (int j=0; j<width; j++)
			{
				uchar val = src.at<uchar>(i,j);
				uchar neg = MAX_PATH-val;
				dst.at<uchar>(i,j) = neg;
			}
		}

		// Get the current time again and compute the time difference [s]
		t = ((double)getTickCount() - t) / getTickFrequency();
		// Print (in the console window) the processing time in [ms] 
		printf("Time = %.3f [ms]\n", t * 1000);

		imshow("input image",src);
		imshow("negative image",dst);
		waitKey();
	}
}

void testParcurgereSimplaDiblookStyle()
{
	char fname[MAX_PATH];
	while (openFileDlg(fname))
	{
		Mat src = imread(fname, CV_LOAD_IMAGE_GRAYSCALE);
		int height = src.rows;
		int width = src.cols;
		Mat dst = src.clone();

		double t = (double)getTickCount(); // Get the current time [s]

		// the fastest approach using the “diblook style”
		uchar *lpSrc = src.data;
		uchar *lpDst = dst.data;
		int w = (int) src.step; // no dword alignment is done !!!
		for (int i = 0; i<height; i++)
			for (int j = 0; j < width; j++) {
				uchar val = lpSrc[i*w + j];
				lpDst[i*w + j] = 255 - val;
			}

		// Get the current time again and compute the time difference [s]
		t = ((double)getTickCount() - t) / getTickFrequency();
		// Print (in the console window) the processing time in [ms] 
		printf("Time = %.3f [ms]\n", t * 1000);

		imshow("input image",src);
		imshow("negative image",dst);
		waitKey();
	}
}

void testColor2Gray()
{
	char fname[MAX_PATH];
	while(openFileDlg(fname))
	{
		Mat src = imread(fname);

		int height = src.rows;
		int width = src.cols;

		Mat dst = Mat(height,width,CV_8UC1);

		// Asa se acceseaaza pixelii individuali pt. o imagine RGB 24 biti/pixel
		// Varianta ineficienta (lenta)
		for (int i=0; i<height; i++)
		{
			for (int j=0; j<width; j++)
			{
				Vec3b v3 = src.at<Vec3b>(i,j);
				uchar b = v3[0];
				uchar g = v3[1];
				uchar r = v3[2];
				dst.at<uchar>(i,j) = (r+g+b)/3;
			}
		}
		
		imshow("input image",src);
		imshow("gray image",dst);
		waitKey();
	}
}

void testBGR2HSV()
{
	char fname[MAX_PATH];
	while (openFileDlg(fname))
	{
		Mat src = imread(fname);
		int height = src.rows;
		int width = src.cols;

		// Componentele d eculoare ale modelului HSV
		Mat H = Mat(height, width, CV_8UC1);
		Mat S = Mat(height, width, CV_8UC1);
		Mat V = Mat(height, width, CV_8UC1);

		// definire pointeri la matricele (8 biti/pixeli) folosite la afisarea componentelor individuale H,S,V
		uchar* lpH = H.data;
		uchar* lpS = S.data;
		uchar* lpV = V.data;

		Mat hsvImg;
		cvtColor(src, hsvImg, CV_BGR2HSV);

		// definire pointer la matricea (24 biti/pixeli) a imaginii HSV
		uchar* hsvDataPtr = hsvImg.data;

		for (int i = 0; i<height; i++)
		{
			for (int j = 0; j<width; j++)
			{
				int hi = i*width * 3 + j * 3;
				int gi = i*width + j;

				lpH[gi] = hsvDataPtr[hi] * 510 / 360;		// lpH = 0 .. 255
				lpS[gi] = hsvDataPtr[hi + 1];			// lpS = 0 .. 255
				lpV[gi] = hsvDataPtr[hi + 2];			// lpV = 0 .. 255
			}
		}

		imshow("input image", src);
		imshow("H", H);
		imshow("S", S);
		imshow("V", V);

		waitKey();
	}
}

void testResize()
{
	char fname[MAX_PATH];
	while(openFileDlg(fname))
	{
		Mat src;
		src = imread(fname);
		Mat dst1,dst2;
		//without interpolation
		resizeImg(src,dst1,320,false);
		//with interpolation
		resizeImg(src,dst2,320,true);
		imshow("input image",src);
		imshow("resized image (without interpolation)",dst1);
		imshow("resized image (with interpolation)",dst2);
		waitKey();
	}
}
struct peak {
	int theta, ro, hval;
	bool operator < (const peak& o) const {
		return hval > o.hval;
	}
};
void testCanny()
{
	char fname[MAX_PATH];
	while(openFileDlg(fname))
	{
		Mat src,dst,gauss;
		src = imread(fname,CV_LOAD_IMAGE_GRAYSCALE);
		double k = 0.4;
		int pH = 50;
		int pL = (int) k*pH;
		GaussianBlur(src, gauss, Size(5, 5), 0.8, 0.8);
		Canny(gauss,dst,pL,pH,3);
		imshow("input image",src);
		imshow("canny",dst);
		waitKey();
	}
}

void testVideoSequence()
{
	VideoCapture cap("Videos/rubic.avi"); // off-line video from file
	//VideoCapture cap(0);	// live video from web cam
	if (!cap.isOpened()) {
		printf("Cannot open video capture device.\n");
		waitKey(0);
		return;
	}
		
	Mat edges;
	Mat frame;
	char c;

	while (cap.read(frame))
	{
		Mat grayFrame;
		cvtColor(frame, grayFrame, CV_BGR2GRAY);
		Canny(grayFrame,edges,40,100,3);
		imshow("source", frame);
		imshow("gray", grayFrame);
		imshow("edges", edges);
		c = cvWaitKey(0);  // waits a key press to advance to the next frame
		if (c == 27) {
			// press ESC to exit
			printf("ESC pressed - capture finished\n"); 
			break;  //ESC pressed
		};
	}
}


void testSnap()
{
	VideoCapture cap(0); // open the deafult camera (i.e. the built in web cam)
	if (!cap.isOpened()) // openenig the video device failed
	{
		printf("Cannot open video capture device.\n");
		return;
	}

	Mat frame;
	char numberStr[256];
	char fileName[256];
	
	// video resolution
	Size capS = Size((int)cap.get(CV_CAP_PROP_FRAME_WIDTH),
		(int)cap.get(CV_CAP_PROP_FRAME_HEIGHT));

	// Display window
	const char* WIN_SRC = "Src"; //window for the source frame
	namedWindow(WIN_SRC, CV_WINDOW_AUTOSIZE);
	cvMoveWindow(WIN_SRC, 0, 0);

	const char* WIN_DST = "Snapped"; //window for showing the snapped frame
	namedWindow(WIN_DST, CV_WINDOW_AUTOSIZE);
	cvMoveWindow(WIN_DST, capS.width + 10, 0);

	char c;
	int frameNum = -1;
	int frameCount = 0;

	for (;;)
	{
		cap >> frame; // get a new frame from camera
		if (frame.empty())
		{
			printf("End of the video file\n");
			break;
		}

		++frameNum;
		
		imshow(WIN_SRC, frame);

		c = cvWaitKey(10);  // waits a key press to advance to the next frame
		if (c == 27) {
			// press ESC to exit
			printf("ESC pressed - capture finished");
			break;  //ESC pressed
		}
		if (c == 115){ //'s' pressed - snapp the image to a file
			frameCount++;
			fileName[0] = NULL;
			sprintf(numberStr, "%d", frameCount);
			strcat(fileName, "Images/A");
			strcat(fileName, numberStr);
			strcat(fileName, ".bmp");
			bool bSuccess = imwrite(fileName, frame);
			if (!bSuccess) 
			{
				printf("Error writing the snapped image\n");
			}
			else
				imshow(WIN_DST, frame);
		}
	}

}

void MyCallBackFunc(int event, int x, int y, int flags, void* param)
{
	//More examples: http://opencvexamples.blogspot.com/2014/01/detect-mouse-clicks-and-moves-on-image.html
	Mat* src = (Mat*)param;
	if (event == CV_EVENT_LBUTTONDOWN)
		{
			printf("Pos(x,y): %d,%d  Color(RGB): %d,%d,%d\n",
				x, y,
				(int)(*src).at<Vec3b>(y, x)[2],
				(int)(*src).at<Vec3b>(y, x)[1],
				(int)(*src).at<Vec3b>(y, x)[0]);
		}
}

void testMouseClick()
{
	Mat src;
	// Read image from file 
	char fname[MAX_PATH];
	while (openFileDlg(fname))
	{
		src = imread(fname);
		//Create a window
		namedWindow("My Window", 1);

		//set the callback function for any mouse event
		setMouseCallback("My Window", MyCallBackFunc, &src);

		//show the image
		imshow("My Window", src);

		// Wait until user press some key
		waitKey(0);
	}
}


Mat convertToGrayscale(Mat src)
{
	Mat new_img(src.rows, src.cols, CV_8UC1);

	for (int i = 0; i < src.rows; i++)
	{
		for (int j = 0; j < src.cols; j++)
		{
			Vec3b pixel = src.at<Vec3b>(i, j);
			uchar r = pixel[2];
			uchar g = pixel[1];
			uchar b = pixel[0];

			new_img.at<uchar>(i, j) = (r + g + b) / 3;

		}
	}

	return new_img;
}

void filtruGeneral_trece_jos(int w, Mat H)
{
	Mat src;
	char fname[MAX_PATH];
	while (openFileDlg(fname))
	{
		src = imread(fname, CV_8UC1);
		Mat dst = Mat(src.rows, src.cols, CV_8UC1);
		imshow("Imagine sursa", src);

		for (int i = w / 2; i < src.rows - (w / 2); i++)
		{
			for (int j = (w / 2); j < src.cols - (w / 2); j++)
			{
				int sum = 0;
				float d = (float)1 / (w * w);

				for (int u = 0; u < w; u++)
				{
					for (int v = 0; v < w; v++)
					{
						sum = sum + H.at<uchar>(u, v) * src.at<uchar>(i + u - (w / 2), j + v - (w / 2));
					}
				}
				dst.at<uchar>(i, j) = d * sum;
			}
		}
		imshow("Imagine destinatie", dst);
		waitKey(0);
	}
}

void hough()
{

	// Read image from file 
	char fname[MAX_PATH];
	while (openFileDlg(fname))
	{
		Mat src = imread(fname, CV_LOAD_IMAGE_GRAYSCALE);
		int height = src.rows;
		int width = src.cols;
		Mat dst = Mat(height, width, CV_8UC1);



		int rho = 0;
		float thetaRad = 0;
		float rhoMax = 0;
		rhoMax = sqrt(height*height + width * width);
		int maxHough = 0;
		//printf("%.2f", rhoMax);

		Mat Hough((int)rhoMax + 1, 360, CV_32SC1);
		Hough.setTo(0);

		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				if (src.at<uchar>(i, j) == 255)
				{
					for (int theta = 0; theta < 360; theta++)
					{
						thetaRad = theta * CV_PI / 180.f;
						rho = i * cos(thetaRad) + j * sin(thetaRad);
						if (rho >= 0 && rho < rhoMax)
						{
							Hough.at<int>(rho, theta)++;
							if (Hough.at<int>(rho, theta) > maxHough)
								maxHough = Hough.at<int>(rho, theta);
						}


					}

				}
		Mat houghImg;
		Hough.convertTo(houghImg, CV_8UC1, 255.f / maxHough);

		imshow("Hough", houghImg);
		waitKey();

	}

}

bool isAllWhite(int a, int b, int c)
{
	if (a == 255 && b == 255 && c == 255)
	{
		return true;
	}
	return false;
}

bool isYellow(int a, int b, int c)
{
	if (a == 255 && b == 255 && c == 0)
	{
		return true;
	}
	return false;
}

bool isLane(Mat img, int i, int j)
{
	if ((img.at<uchar>(i, j) < img.at<uchar>(i, j - 1)) && (img.at<uchar>(i, j - 1) - img.at<uchar>(i, j) >= 100))
	{
		return true;
	}
	else
		if ((img.at<uchar>(i, j) < img.at<uchar>(i, j + 1)) && (img.at<uchar>(i, j + 1) - img.at<uchar>(i, j) >= 60))
		{
			return true;
		}
		else
			return false;
}

bool isAlmostWhite(int a, int b, int c)
{
	if ((a <= 255 && a >= 196) && (b <= 255 && b >= 196) && (c <= 255 && c >= 196))
	{
		return true;
	}
	return false;
}

bool isAlmostYellow(int a, int b, int c)
{
	if ((a <= 255 && a >= 196) && (b <= 255 && b >= 196) && (c <= 50 && c >= 150))
	{
		return true;
	}
	return false;
}




void detectLaneMarking()
{
	
	char fname[MAX_PATH];
	openFileDlg(fname);
	Mat src = imread(fname, CV_LOAD_IMAGE_COLOR);
/*
	VideoCapture cap("solidWhiteRight.mp4");
	if (!cap.isOpened())
	{
		perror("Eroare la deschiderea video-ului");
		exit(-1);
	}

	while (1) {
		Mat frame;
		cap >> frame;
		if (frame.empty())
		{
			break;
		}
		imshow("Frame", frame);
		char c = (char)waitKey(25);
		if (c == 27) {
			break;
		}

	}
	*/


	imshow("Source Image", src);
	waitKey(0);

	Mat gray(src.rows, src.cols, CV_8UC1);

	//convert original image to grayscale
	for (int i = 0; i < src.rows; i++) {
		for (int j = 0; j < src.cols; j++) {
			int red = src.at<Vec3b>(i, j)[2];
			int green = src.at<Vec3b>(i, j)[1];
			int blue = src.at<Vec3b>(i, j)[0];
			gray.at<uchar>(i, j) = (red + green + blue) / 3;
		}
	}	

	imshow("Image Grayscaler", gray);
	waitKey(0);

	//reduce noise with a kernel 3x3
	//blur(gray, gray, Size(3, 3));
	
	Mat filtru = Mat(src.rows, src.cols, CV_8UC1);
	Mat modul = Mat(src.rows, src.cols, CV_8UC1);
	Mat directie = Mat(src.rows, src.cols, CV_8UC1);

	Mat Hx = Mat(3, 3, CV_32F);
	Hx.at<float>(0, 0) = -1;
	Hx.at<float>(1, 0) = -2;
	Hx.at<float>(2, 0) = -1;
	Hx.at<float>(0, 1) = 0;
	Hx.at<float>(1, 1) = 0;
	Hx.at<float>(2, 1) = 0;
	Hx.at<float>(0, 2) = 1;
	Hx.at<float>(1, 2) = 2;
	Hx.at<float>(2, 2) = 1;

	Mat Hy = Mat(3, 3, CV_32F);
	Hy.at<float>(0, 0) = 1;
	Hy.at<float>(1, 0) = 0;
	Hy.at<float>(2, 0) = -1;
	Hy.at<float>(0, 1) = 2;
	Hy.at<float>(1, 1) = 0;
	Hy.at<float>(2, 1) = -2;
	Hy.at<float>(0, 2) = 1;
	Hy.at<float>(1, 2) = 0;
	Hy.at<float>(2, 2) = -1;
	int w=3;
	int k = w / 2;
	float G[7][7] = { 0 };
	float sigma = (float)w / 6;

	float pixeli[256];
	int hist[256] = { 0 };


	//pas 1 - filtru Gaussian
	for (int x = 0; x < w; x++)
	{
		for (int y = 0; y < w; y++)
		{
			G[x][y] = 1.0 / (2 * PI * sigma * sigma) * exp(-(((x - 2) * (x - 2) + (y - 2) * (y - 2)) / (2 * sigma * sigma)));
		}
	}

	for (int x = k; x < src.rows - k; x++)
	{
		for (int y = k; y < src.cols - k; y++)
		{
			int aux = 0;
			for (int i = -k; i <= k; i++)
			{
				for (int j = -k; j <= k; j++)
				{
					aux += src.at<uchar>(x + j, y + i) * G[j + k][i + k];
				}

				filtru.at<uchar>(x, y) = aux;
			}
		}
	}

	//imshow("FIltru Gaussian", filtru);
	//waitKey(0);
	
	blur(gray, gray, Size(3, 3));

	imshow("Filtru Gaussian ", gray);
	waitKey(0);


	Mat cannyResult(src.rows, src.cols, CV_8UC3);
	Canny(gray, cannyResult, 125, 250, 3);

	imshow("Canny", cannyResult);
	waitKey(0);
	
	/*int height = cannyResult.rows;
	int width = cannyResult.cols;
	Mat dst = Mat(height, width, CV_8UC1);



	int rho = 0;
	float thetaRad = 0;
	float rhoMax = 0;
	rhoMax = sqrt(height*height + width * width);
	int maxHough = 0;
	

	Mat Hough((int)rhoMax + 1, 360, CV_32SC1);
	Hough.setTo(0);

	for (int i = 0; i < height; i++)
		for (int j = 0; j < width; j++)
			if (src.at<uchar>(i, j) == 255)
			{
				for (int theta = 0; theta < 360; theta++)
				{
					thetaRad = theta * CV_PI / 180.f;
					rho = i * cos(thetaRad) + j * sin(thetaRad);
					if (rho >= 0 && rho < rhoMax)
					{
						Hough.at<int>(rho, theta)++;
						if (Hough.at<int>(rho, theta) > maxHough)
							maxHough = Hough.at<int>(rho, theta);
					}


				}

			}
	Mat houghImg;
	Hough.convertTo(houghImg, CV_8UC1, 255.f / maxHough);

	imshow("Hough", houghImg);
	waitKey();


	int rho = 0;
	float thetaRad = 0;
	float rhoMax = 0;
	rhoMax = sqrt(height*height + width * width);
	int maxHough = 0;
	int maxime_locale[500] = { 0 };
	int n = 3;
	int start = 0;
	int final = height - n / 3;
	int maxElement = 0;


	Mat Hough2((int)rhoMax + 1, 360, CV_32SC1);
	Hough2.setTo(0);

	for (int i = 0; i < height; i++)
		for (int j = 0; j < width; j++)
			if (src.at<uchar>(i, j) == 255)
			{
				for (int theta = 0; theta < 360; theta++)
				{
					thetaRad = theta * CV_PI / 180.f;
					rho = i * cos(thetaRad) + j * sin(thetaRad);
					if (rho >= 0 && rho < rhoMax)
					{
						Hough2.at<int>(rho, theta)++;
						if (Hough2.at<int>(rho, theta) > maxHough)
							maxHough = Hough2.at<int>(rho, theta);

					}


				}

			}
	while (start + 3 < final)
	{
		for (int k = start; k < start + 3; k++)
			for (int l = start; l < start + 3; l++)
			{
				if (Hough2.at<int>(k, l) > maxElement)
					maxElement = Hough2.at<int>(k, l);
			}
		if (Hough2.at<int>(start + 1, start + 1) == maxElement)
			maxime_locale[start] = maxElement;
		start++;
	}
	Mat houghImg;
	Hough2.convertTo(houghImg, CV_8UC1, 255.f / maxHough);

	for (int i = 0; i < 500; i++)
		printf("%d ", maxime_locale[i]);



	imshow("Hough", houghImg);
	waitKey();
	*/


	std::vector<Vec4i> lines;
	HoughLinesP(cannyResult, lines, 1, CV_PI / 180, 20, 50, 10);

	Mat coloredCannyResult(src.rows, src.cols, CV_8UC3);
	cvtColor(cannyResult, coloredCannyResult, CV_GRAY2BGR);
	for (int i = 0; i < lines.size(); i++)
	{
		Vec4i l = lines[i];
		Point p1 = Point(l[0], l[1]);
		Point p2 = Point(l[2], l[3]);
		float magnitude = sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
		line(coloredCannyResult, p1, p2, Scalar(0, 0, 255), 2, 8);
		printf("%.3f\n", magnitude);
	}
	Mat finalDest = src.clone();

	for (int i = src.rows / 2; i < src.rows; i++) {
		for (int j = 0; j < src.cols; j++) {
			if (coloredCannyResult.at<Vec3b>(i, j)[2] == 255 && coloredCannyResult.at<Vec3b>(i, j)[1] == 0 && coloredCannyResult.at<Vec3b>(i, j)[0] == 0)
			{
				int a = finalDest.at<Vec3b>(i, j)[2];
				int b = finalDest.at<Vec3b>(i, j)[1];
				int c = finalDest.at<Vec3b>(i, j)[0];
				if (isAllWhite(a, b, c) || isAlmostWhite(a, b, c) || isAlmostYellow(a,b,c) || isYellow(a,b,c) || (isAlmostWhite(a, b, c) && isLane(finalDest, i, j)) || (isAlmostYellow(a, b, c) && isLane(finalDest, i, j)))
				{
					finalDest.at<Vec3b>(i, j)[2] = 255;
					finalDest.at<Vec3b>(i, j)[1] = 0;
					finalDest.at<Vec3b>(i, j)[0] = 0;
				}
			}
		}
	}
	

	imshow("Hough Transform", coloredCannyResult);
	waitKey(0);


	imshow("Hough Transform over Source", finalDest);
	waitKey(0);

	for (int i = src.rows - 1; i > src.rows * 9 / 16; i--) {

		int j = src.cols * 3 / 7;
		while (j <= src.cols && coloredCannyResult.at<Vec3b>(i, j)[2] != 255 && coloredCannyResult.at<Vec3b>(i, j)[1] == 0 && coloredCannyResult.at<Vec3b>(i, j)[0] == 0) {
			finalDest.at<Vec3b>(i, j)[2] = 0;
			finalDest.at<Vec3b>(i, j)[1] = 255;
			finalDest.at<Vec3b>(i, j)[0] = 0;
			j++;
		}

		int k = src.cols * 3 / 7 + 1;
		while (k > 0 && coloredCannyResult.at<Vec3b>(i, k)[2] != 255 && coloredCannyResult.at<Vec3b>(i, k)[1] == 0 && coloredCannyResult.at<Vec3b>(i, k)[0] == 0) {
			finalDest.at<Vec3b>(i, k)[2] = 0;
			finalDest.at<Vec3b>(i, k)[1] = 255;
			finalDest.at<Vec3b>(i, k)[0] = 0;
			k--;
		}
	}

	

	imshow("Final", finalDest);
	waitKey(0);
	
	
}


void detectLaneMarking_Video()
{
	VideoCapture cap("Videos/solidWhiteRight.mp4");
	if (!cap.isOpened())
	{
		perror("Eroare la deschiderea video-ului");
		exit(-1);
	}

	while (1) {
		Mat frame;
		cap >> frame;
		if (frame.empty())
		{
			break;
		}
		//imshow("Frame", frame);
		char c = (char)waitKey(5);
		if (c == 27) {
			break;
		}
		Mat grayscale;
		cvtColor(frame, grayscale, CV_RGB2GRAY);

		//imshow("MyVideo", grayscale);

		if (waitKey(30) == 27)
		{
			break;
		}
		blur(grayscale, grayscale, Size(5, 5)); // To blur the image.
		//imshow("Video blurat", grayscale);

		Mat cannyResult;
		Canny(grayscale, cannyResult, 50, 150, 3);

		//imshow("Canny", cannyResult);
		//waitKey(0);

		std::vector<Vec4i> lines;
		HoughLinesP(cannyResult, lines, 1, CV_PI / 180, 20, 50, 10);

		Mat coloredCannyResult;
		cvtColor(cannyResult, coloredCannyResult, CV_GRAY2BGR);

		for (int i = 0; i < lines.size(); i++)
		{
			Vec4i l = lines[i];
			Point p1 = Point(l[0], l[1]);
			Point p2 = Point(l[2], l[3]);
			float magnitude = sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
			line(coloredCannyResult, p1, p2, Scalar(0, 0, 255), 2, 8);
			//printf("%.3f\n", magnitude);
		}
		//imshow("Hough Transform", coloredCannyResult);
		//waitKey(0);
		Mat finalDest = frame.clone();
		for (int i = frame.rows / 2; i < frame.rows; i++) {
			for (int j = 0; j < frame.cols; j++) {
				if (coloredCannyResult.at<Vec3b>(i, j)[2] == 255 && coloredCannyResult.at<Vec3b>(i, j)[1] == 0 && coloredCannyResult.at<Vec3b>(i, j)[0] == 0)
				{
					int a = finalDest.at<Vec3b>(i, j)[2];
					int b = finalDest.at<Vec3b>(i, j)[1];
					int c = finalDest.at<Vec3b>(i, j)[0];
					if (isAllWhite(a, b, c) || isAlmostWhite(a, b, c) || (isAlmostWhite(a, b, c) && isLane(finalDest, i, j)))
					{
						finalDest.at<Vec3b>(i, j)[2] = 255;
						finalDest.at<Vec3b>(i, j)[1] = 0;
						finalDest.at<Vec3b>(i, j)[0] = 0;
					}
				}
			}
		}
		//imshow("Hough Transform over Source", finalDest);
		//waitKey(0);

		for (int i = frame.rows - 1; i > frame.rows * 9 / 16; i--) {

			int j = frame.cols * 3 / 7;
			while (j <= frame.cols && coloredCannyResult.at<Vec3b>(i, j)[2] != 255 && coloredCannyResult.at<Vec3b>(i, j)[1] == 0 && coloredCannyResult.at<Vec3b>(i, j)[0] == 0) {
				finalDest.at<Vec3b>(i, j)[2] = 0;
				finalDest.at<Vec3b>(i, j)[1] = 255;
				finalDest.at<Vec3b>(i, j)[0] = 0;
				j++;
			}

			int k = frame.cols * 3 / 7 + 1;
			while (k > 0 && coloredCannyResult.at<Vec3b>(i, k)[2] != 255 && coloredCannyResult.at<Vec3b>(i, k)[1] == 0 && coloredCannyResult.at<Vec3b>(i, k)[0] == 0) {
				finalDest.at<Vec3b>(i, k)[2] = 0;
				finalDest.at<Vec3b>(i, k)[1] = 255;
				finalDest.at<Vec3b>(i, k)[0] = 0;
				k--;
			}
		}

		imshow("Final", finalDest);
		waitKey(0);


	}
		

	
	



}



int main()
{
	int op;
	do
	{
		system("cls");
		destroyAllWindows();
		printf("Menu:\n");
		printf(" 1 - Open image\n");
		printf(" 2 - Open BMP images from folder\n");
		printf(" 3 - Image negative - diblook style\n");
		printf(" 4 - BGR->HSV\n");
		printf(" 5 - Resize image\n");
		printf(" 6 - Canny edge detection\n");
		printf(" 7 - Edges in a video sequence\n");
		printf(" 8 - Snap frame from live video\n");
		printf(" 9 - Mouse callback demo\n");
		printf(" 10 - Detect Traffic Lane\n");
		printf(" 11 - Detect Traffic Lane - Video\n");

		printf(" 0 - Exit\n\n");
		printf("Option: ");
		scanf("%d",&op);
		switch (op)
		{
			case 1:
				testOpenImage();
				break;
			case 2:
				testOpenImagesFld();
				break;
			case 3:
				testParcurgereSimplaDiblookStyle(); //diblook style
				break;
			case 4:
				//testColor2Gray();
				testBGR2HSV();
				break;
			case 5:
				testResize();
				break;
			case 6:
				testCanny();
				break;
			case 7:
				testVideoSequence();
				break;
			case 8:
				testSnap();
				break;
			case 9:
				testMouseClick();
				break;
			case 10:
				detectLaneMarking();
				break;
			case 11:
				detectLaneMarking_Video();
				break;


		}
	}
	while (op!=0);
	return 0;
}















/*//compute edge detection using Canny Algorithm
Mat cannyResult(src.rows, src.cols, CV_8UC1);
Canny(gray, cannyResult, 125, 250, 3);

for (int i = src.rows / 2 - 1; i <= src.rows / 2 + 5; i++) {
	for (int j = 0; j < src.cols; j++) {
		cannyResult.at<uchar>(i, j) = 0;
	}
}

imshow("Canny", cannyResult);
waitKey(0);
*/