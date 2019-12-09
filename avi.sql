select s.yearsinProgram, count(s.s_id)/tmp.students as percentage
from taughtby tb, student s, (select count(stu.s_id) as students, stu.yearsinProgram as years
								from student stu
								group by stu.yearsinProgram) tmp
where tb.u_id = s.s_id and s.yearsinProgram = tmp.years
group by s.yearsinProgram