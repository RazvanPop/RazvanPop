library IEEE;	
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity timer30 is
 port( CLK, R, en:  in std_logic;
       carry:out std_logic :='0');
end timer30;

architecture arh of timer30 is

begin 
	
process(CLK,R)
variable temp:std_logic_vector(4 downto 0) := "00000";
begin 
	if R ='1' then 
		temp :="00001";
	else if en='1' then 		
			if carry'driving_value = '0' then
				if CLK='1' and clk'event then 
					temp :=temp+1;
					if temp = "11110" then 
						carry <='1';
					end if;
				end if;
			end if;
		  end if;
	end if;
end process;
end architecture;