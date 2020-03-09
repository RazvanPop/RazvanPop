library IEEE;	
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;


entity cuptor is
	port(CLOCK, RESET, Start, IA:in std_logic;	
		reglare_temperatura_exterior: in INTEGER;
	    PI,coacere, introducere_aliment:out std_logic);
end cuptor;

architecture CUPTOR of cuptor is
type STARE_T is (A,B,C,D,E); 

component num30 is
 port( CLK, R, en:  in std_logic;
       carry:out std_logic :='0');
end component;

component num5 is
 port( CLK, R, en:  in std_logic;
       carry:out std_logic :='0');
end component;
signal enable_num5,enable_num30, terminare_num5, terminare_num30,reset_num5, reset_num30: STD_LOGIC;
signal STARE, NXSTARE: STARE_T;
begin 
	
	Timer30 :num30 port map(CLOCK,RESET,enable_num30, terminare_num30);
    Timer5 :num5 port map(CLOCK,RESET,enable_num5, terminare_num5);
ACTUALIZARE_STARE:process(RESET, CLOCK)
begin
		if (RESET = '1') then
			STARE <= A;
		elsif CLOCK'event and CLOCK = '1' then
				STARE <= NXSTARE;
        end if;
end process ACTUALIZARE_STARE;

			
TRANSITIONS:process(STARE, CLOCK) 
variable temp: integer:=0;
begin
	--initializare
	reset_num5 <= '0'; 
	reset_num30 <='0'; 
	PI <='0';  
	coacere <= '0'; 
	enable_num5 <='0'; 
	enable_num30 <='0';	
	introducere_aliment <='0';
	
	case STARE is
		when A=> reset_num5 <='1'; 
		reset_num30 <='1';
		if(Start ='1') then NXSTARE <=B;
			else NXSTARE <=A;
		end if;
		
		when B=> PI <='1';
				temp :=temp+20;
				if(reglare_temperatura_exterior <= temp) then 
						NXSTARE <=C;
						introducere_aliment <='1';  
				else 
						NXSTARE <=B;
				end if;
		
		when C=> enable_num5 <='1';
				if(IA ='1' and terminare_num5='0') then 
						NXSTARE <=D; 
				elsif terminare_num5='1' then
					NXSTARE <=A;
				else 
					NXSTARE <=C;
				end if;
		
		when D=> if(Start ='1') then 
					NXSTARE <=E;
				else 
					NXSTARE <=C;
				end if;
		
		when E =>  coacere <='1'; 
		          enable_num30 <='1';
				if(terminare_num30='0') then 
					NXSTARE <= E; 
				else 
					NXSTARE <=A; 
				end if;
	end case;
	end process TRANSITIONS;
end CUPTOR;
		