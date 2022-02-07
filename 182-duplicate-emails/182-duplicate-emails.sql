# Write your MySQL query statement below
select c.email as Email from
(select email,count(email) as count from person group by email) as c
where c.count > 1