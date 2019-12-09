(select taughtby.course_id as courses, count(professor.p_id) as professors, 0 as students
from professor
inner join taughtby on professor.p_id = taughtby.u_id
group by taughtby.course_id)
UNION
(select taughtby.course_id as courses,0 as professors, count(student.s_id) as students
from student
inner join taughtby on student.s_id = taughtby.u_id
group by taughtby.course_id)
order by courses asc