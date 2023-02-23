select*from student;
select*from student where student.age>= 18 AND student.age<=22;
select name,count(name) from student group by student.name;
select*from student where name like'%А%';
select*from student where student.age<student.id;
select*from student order by student.age;