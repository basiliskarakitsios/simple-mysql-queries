create or replace VIEW professorCount
AS 
select p_id , count(*) as students
from advisedby
group by p_id;

select * from professorCount
