.386
.model flat, stdcall
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;includem biblioteci, si declaram ce functii vrem sa importam
includelib msvcrt.lib
extern exit: proc
extern malloc: proc
extern memset: proc

includelib canvas.lib
extern BeginDrawing: proc
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;declaram simbolul start ca public - de acolo incepe executia
public start
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;sectiunile programului, date, respectiv cod
.data
;aici declaram date
window_title DB "Calculator",0
area_width EQU 1200
area_height EQU 800
area DD 0
;vector dd 81 dup(0)

counter DD 0 ; numara evenimentele de tip timer
char_loc DD 405

arg1 EQU 8
arg2 EQU 12
arg3 EQU 16
arg4 EQU 20

symbol_width EQU 10
symbol_height EQU 20
include digits.inc
include letters.inc

.code

make_number macro n_in, n_out

	mov eax, n_out
	mul ten
	add eax, n_in
	mov n_out, eax
	
endm

	;aici se scrie codul
	; procedura make_text afiseaza o litera sau o cifra la coordonatele date
; arg1 - simbolul de afisat (litera sau cifra)
; arg2 - pointer la vectorul de pixeli
; arg3 - pos_x
; arg4 - pos_y
make_text proc
	push ebp
	mov ebp, esp
	pusha
	
	mov eax, [ebp+arg1] ; citim simbolul de afisat
	cmp eax, 'A'
	jl make_digit
	cmp eax, 'Z'
	jg make_digit
	sub eax, 'A'
	lea esi, letters
	jmp draw_text
make_digit:
	cmp eax, '0'
	jl make_space
	cmp eax, '9'
	jg make_space
	sub eax, '0'
	lea esi, digits
	jmp draw_text
make_space:	
	mov eax, 26 ; de la 0 pana la 25 sunt litere, 26 e space
	lea esi, letters
	
draw_text:
	mov ebx, symbol_width
	mul ebx
	mov ebx, symbol_height
	mul ebx
	add esi, eax
	mov ecx, symbol_height
bucla_simbol_linii:
	mov edi, [ebp+arg2] ; pointer la matricea de pixeli
	mov eax, [ebp+arg4] ; pointer la coord y
	add eax, symbol_height
	sub eax, ecx
	mov ebx, area_width
	mul ebx
	add eax, [ebp+arg3] ; pointer la coord x
	shl eax, 2 ; inmultim cu 4, avem un DWORD per pixel
	add edi, eax
	push ecx
	mov ecx, symbol_width
bucla_simbol_coloane:
	cmp byte ptr [esi], 0
	je simbol_pixel_alb
	mov dword ptr [edi], 0
	jmp simbol_pixel_next
simbol_pixel_alb:
	mov dword ptr [edi], 0FFFFFFh
simbol_pixel_next:
	inc esi
	add edi, 4
	loop bucla_simbol_coloane
	pop ecx
	loop bucla_simbol_linii
	popa
	mov esp, ebp
	pop ebp
	ret
make_text endp

; un macro ca sa apelam mai usor desenarea simbolului
make_text_macro macro symbol, drawArea, x, y
	push y
	push x
	push drawArea
	push symbol
	call make_text
	add esp, 16
endm

; functia de desenare - se apeleaza la fiecare click
; sau la fiecare interval de 200ms in care nu s-a dat click
; arg1 - evt (0 - initializare, 1 - click, 2 - s-a scurs intervalul fara click)
; arg2 - x
; arg3 - y
draw proc
    jmp drawing
	
drawing:
	push ebp
	mov ebp, esp
	pusha
	
	mov eax, [ebp+arg1]
	cmp eax, 1
	jz evt_click
	cmp eax, 2
	jz evt_timer ; nu s-a efectuat click pe nimic
	;mai jos e codul care intializeaza fereastra cu pixeli albi
	mov eax, area_width
	mov ebx, area_height
	mul ebx
	shl eax, 2
	push eax
	push 255
	push area
	call memset
	add esp, 12
	jmp afisare_litere
	
evt_click:

	jmp check_left

	
delete:
	cmp char_loc, 405
	je afisare_litere
	sub char_loc, 10
	make_text_macro ' ', area, char_loc, 150
	jmp afisare_litere
	
clear:
	cmp char_loc, 405
	je afisare_litere
	sub char_loc, 10
	make_text_macro ' ', area, char_loc, 150
	jmp clear
	

check_left:
	mov eax, 0
	mov eax, [ebp+arg2]
	cmp eax, 600
	jg check_right
	jmp afisare_litere

check_right:
	mov eax, 0
	mov eax, [ebp+arg2]
	cmp eax, 900
	jl check_up
	jmp afisare_litere
	
check_up:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 400
	jg check_bottom
	jmp afisare_litere
	
check_bottom:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 600
	jl compx1
	jmp afisare_litere	
	
compx1:
	mov eax, 0
	mov eax, [ebp+arg2]
	cmp eax, 700
	jl compCE
	cmp eax, 700
	jg	compx2
	
compx2:
	mov eax, 0
	mov eax, [ebp+arg2]
	cmp eax, 800
	jl compy0
	cmp eax, 800
	jg compC
	
	
compCE:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 600
	jl compCE1
	
compCE1:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 550
	jg clear
	jmp compy3

compy0:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 600
	jl compy00

compy00:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 550
	jg writeText0
	jmp compy2
	
compy2:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 550
	jl compy02
	
compy02:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 500
	jg writeText2
	jmp compy5
	
compy5:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 500
	jl compy05
	
compy05:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 450
	jg writeText5
	jmp compy8
	
compy8:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 450
	jl compy08
	
compy08:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 400
	jg writeText8

compC:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 600
	jl compC1
	
compC1:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 550
	jg delete
	jmp compy1
	
compy1:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 550
	jl compy01
	
compy01:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 500
	jg writeText1
	jmp compy4
	
compy4:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 500
	jl compy04
	
compy04:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 450
	jg writeText4
	jmp compy7
	
compy3:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 550
	jl compy03

compy03:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 500
	jg writeText3
	jmp compy6
	
compy6:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 500
	jl compy06
	
compy06:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 450
	jg writeText6
	jmp compy9
	
compy9:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 450
	jl compy09
	
	
compy09:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 400
	jg writeText9
	
compy7:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 450
	jl compy07
	
compy07:
	mov eax, 0
	mov eax, [ebp+arg3]
	cmp eax, 400
	jg writeText7
writeText0:
	make_text_macro '0', area, char_loc, 150
	add char_loc, 10
	;add counter1, 1
	jmp afisare_litere
	
writeText1:
	make_text_macro '1', area, char_loc, 150
	add char_loc, 10
	;add counter1, 1
	jmp afisare_litere
	
writeText2:
	make_text_macro '2', area, char_loc, 150
	add char_loc, 10
	;add counter1, 1
	jmp afisare_litere
	
writeText3:
	make_text_macro '3', area, char_loc, 150
   add char_loc, 10
	;add counter1, 1
	jmp afisare_litere
	
writeText4:
	make_text_macro '4', area, char_loc, 150
	add char_loc, 10
	;add counter1, 1
	jmp afisare_litere

writeText5:
	make_text_macro '5', area, char_loc, 150
	add char_loc, 10
	;add counter1, 1
	jmp afisare_litere
	
writeText6:
	make_text_macro '6', area, char_loc, 150
	add char_loc, 10
	;add counter1, 1
	jmp afisare_litere
	
writeText7:
	make_text_macro '7', area, char_loc, 150
	add char_loc, 10
	;add counter1, 1
	jmp afisare_litere
	
writeText8:
	make_text_macro '8', area, char_loc, 150
	add char_loc, 10
	;add counter1, 1
	jmp afisare_litere
	
writeText9:
	make_text_macro '9', area, char_loc, 150
	add char_loc, 10
	;add counter1, 1
	jmp afisare_litere

evt_timer:
    inc counter
	
	
	
afisare_litere:
	;afisam valoarea counter-ului curent (sute, zeci si unitati)
	mov ebx, 10
	mov eax, counter
	;cifra unitatilor
	mov edx, 0
	div ebx
	add edx, '0'
	make_text_macro edx, area, 30, 10
	;cifra zecilor
	mov edx, 0
	div ebx
	add edx, '0'
	make_text_macro edx, area, 20, 10
	;cifra sutelor
	mov edx, 0
	div ebx
	add edx, '0'
	make_text_macro edx, area, 10, 10
	
	;scriem un mesaj
	
	
	make_text_macro 'P', area, 450, 20
	make_text_macro 'R', area, 460, 20
	make_text_macro 'O', area, 470, 20
	make_text_macro 'I', area, 480, 20
	make_text_macro 'E', area, 490, 20
	make_text_macro 'C', area, 500, 20
	make_text_macro 'T', area, 510, 20
	
	make_text_macro 'L', area, 540, 20
	make_text_macro 'A', area, 550, 20
	
	make_text_macro 'A', area, 580, 20
	make_text_macro 'S', area, 590, 20
	make_text_macro 'A', area, 600, 20
    make_text_macro 'M', area, 610, 20
	make_text_macro 'B', area, 620, 20
	make_text_macro 'L', area, 630, 20
	make_text_macro 'A', area, 640, 20
	make_text_macro 'R', area, 650, 20
	make_text_macro 'E', area, 660, 20
	
	make_text_macro 'C', area, 720, 20
	make_text_macro 'A', area, 730, 20
	make_text_macro 'L', area, 740, 20
	make_text_macro 'C', area, 750, 20
	make_text_macro 'U', area, 760, 20
	make_text_macro 'L', area, 770, 20
	make_text_macro 'A', area, 780, 20
	make_text_macro 'T', area, 790, 20
	make_text_macro 'O', area, 800, 20
	make_text_macro 'R', area, 810, 20
	make_text_macro 'D', area, 830, 20
	make_text_macro 'E', area, 840, 20
	make_text_macro 'B', area, 860, 20
	make_text_macro 'U', area, 870, 20
	make_text_macro 'Z', area, 880, 20
	make_text_macro 'U', area, 890, 20
	make_text_macro 'N', area, 900, 20
	make_text_macro 'A', area, 910, 20
	make_text_macro 'R', area, 920, 20
    make_text_macro '0', area, 745,560
make_text_macro '2', area, 745,515
make_text_macro '5', area, 745,465
make_text_macro '8', area, 745,415
make_text_macro '1', area, 645,515
make_text_macro '4', area, 645,465
make_text_macro '7', area, 645,415
make_text_macro '3', area, 845,515
make_text_macro '6', area, 845,465
make_text_macro '9', area, 845,415

make_text_macro 'D', area, 830,560
make_text_macro 'E', area, 845,560
make_text_macro 'L', area, 860,560

make_text_macro 'A', area, 285,330
make_text_macro 'D', area, 300,330
make_text_macro 'D', area, 315,330

make_text_macro 'S', area, 285,400
make_text_macro 'U', area, 300,400
make_text_macro 'B', area, 315,400

make_text_macro 'M', area, 285,480
make_text_macro 'U', area, 300,480
make_text_macro 'L', area, 315,480

make_text_macro 'D', area, 285,550
make_text_macro 'I', area, 300,550
make_text_macro 'V', area, 315,550

make_text_macro 'D', area , 615,560
make_text_macro 'A', area, 630,560
make_text_macro 'L', area, 645,560
make_text_macro 'L', area, 660,560


	
	;prima linie orizontala de la tabla
mov eax,area_width
mov ebx,100
mul ebx
mov ebx,200
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,700
eticheta0:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta0

	;a doua linie orizontala de la tabla
mov eax,area_width
mov ebx,600
mul ebx
mov ebx,200
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,700
eticheta1:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta1



;prima linie verticala de pe tabla
mov eax,area_width
mov ebx,100
mul ebx
mov ebx,200
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,500
mov ebx,eax
eticheta3:
mov eax,area_width
mul ecx
mov dword ptr [ebx+eax*4], 0FF0000h
loop eticheta3

;a doua linie verticala de pe tabla
mov eax,area_width
mov ebx,100
mul ebx
mov ebx,900
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,500
mov ebx,eax
eticheta4:
mov eax,area_width
mul ecx
mov dword ptr [ebx+eax*4], 0FF0000h
loop eticheta4

;a treia linie orizontala de la tabla
mov eax,area_width
mov ebx,550
mul ebx
mov ebx,600
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,300
eticheta5:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta5


;a patra linie orizontala de la tabla
mov eax,area_width
mov ebx,500
mul ebx
mov ebx,600
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,300
eticheta6:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta6



;a cincea linie orizontala de la tabla
mov eax,area_width
mov ebx,450
mul ebx
mov ebx,600
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,300
eticheta7:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta7
;a sasea linie orizontala de la tabla
mov eax,area_width
mov ebx,400
mul ebx
mov ebx,600
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,300
eticheta8:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta8

;a treia linie verticala de pe tabla
mov eax,area_width
mov ebx,400
mul ebx
mov ebx,600
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,200
mov ebx,eax
eticheta9:
mov eax,area_width
mul ecx
mov dword ptr [ebx+eax*4], 0FF0000h
loop eticheta9

;a patra linie verticala de pe tabla
mov eax,area_width
mov ebx,400
mul ebx
mov ebx,700
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,200
mov ebx,eax
eticheta10:
mov eax,area_width
mul ecx
mov dword ptr [ebx+eax*4], 0FF0000h
loop eticheta10

;a cincea linie verticala de pe tabla
mov eax,area_width
mov ebx,400
mul ebx
mov ebx,800
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,200
mov ebx,eax
eticheta11:
mov eax,area_width
mul ecx
mov dword ptr [ebx+eax*4], 0FF0000h
loop eticheta11

;a sasea linie verticala de pe tabla
mov eax,area_width
mov ebx,300
mul ebx
mov ebx,250
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,300
mov ebx,eax
eticheta12:
mov eax,area_width
mul ecx
mov dword ptr [ebx+eax*4], 0FF0000h
loop eticheta12

;a saptea linie verticala de pe tabla
mov eax,area_width
mov ebx,300
mul ebx
mov ebx,350
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,300
mov ebx,eax
eticheta13:
mov eax,area_width
mul ecx
mov dword ptr [ebx+eax*4], 0FF0000h
loop eticheta13

;a saptea linie orizontala de la tabla
mov eax,area_width
mov ebx,300
mul ebx
mov ebx,250
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,100
eticheta14:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta14

;a opta linie orizontala de la tabla
mov eax,area_width
mov ebx,375
mul ebx
mov ebx,250
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,100
eticheta15:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta15

;a noua linie orizontala de la tabla
mov eax,area_width
mov ebx,450
mul ebx
mov ebx,250
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,100
eticheta16:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta16

;a zecea linie orizontala de la tabla
mov eax,area_width
mov ebx,525
mul ebx
mov ebx,250
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,100
eticheta17:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta17

;a unsprezecea linie orizontala de la tabla
mov eax,area_width
mov ebx,150
mul ebx
mov ebx,400
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,500
eticheta18:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta18

;a doisprezecea linie orizontala de la tabla
mov eax,area_width
mov ebx,200
mul ebx
mov ebx,400
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,500
eticheta19:
mov dword ptr [eax+ecx*4], 0FF0000h
loop eticheta19

;a opta linie verticala de pe tabla
mov eax,area_width
mov ebx,150
mul ebx
mov ebx,400
add eax,ebx
shl eax,2
mov ebx,area
add eax,ebx
mov ecx,50
mov ebx,eax
eticheta20:
mov eax,area_width
mul ecx
mov dword ptr [ebx+eax*4], 0FF0000h
loop eticheta20

final_draw:
	popa
	mov esp, ebp
	pop ebp
	ret
draw endp

start:
	mov eax, area_width
	mov ebx, area_height
	mul ebx
	shl eax, 2
	push eax
	call malloc
	add esp, 4
	mov area, eax
	;apelam functia de desenare a ferestrei
	; typedef void (*DrawFunc)(int evt, int x, int y);
	; void __cdecl BeginDrawing(const char *title, int width, int height, unsigned int *area, DrawFunc draw);
	push offset draw
	push area
	push area_height
	push area_width
	push offset window_title
	call BeginDrawing
	add esp, 20
	
	push 0
	call exit
end start






