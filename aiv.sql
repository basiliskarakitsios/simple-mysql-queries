select hasPosition, count(s_id) as students
from professor inner join advisedby on professor.p_id = advisedby.p_id
group by professor.p_id
order by students desc
limit 1;