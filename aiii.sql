select distinct s_id 
from advisedby 
where p_id in 
(select p_id FROM advisedby where s_id = 81);