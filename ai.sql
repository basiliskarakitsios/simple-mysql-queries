select s1.yearsinProgram as t1, s2.yearsinProgram as t2
from student s1, student s2
where s1.yearsinProgram < ALL (select max(s2.yearsinProgram) from student s2 where s1.yearsinProgram < s2.yearsinProgram)
order by s1.yearsinProgram asc, s2.yearsinProgram desc
limit 1