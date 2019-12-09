select distinct course_id 
from taughtby 
where u_id in
(
	select s_id
    from advisedby
    where u_id = p_id
)