CREATE TABLE e_user (
    user_id bigSerial primary key,
    user_name varchar(256),
    passwd varchar(256),
    email varchar(256),
    create_date timestamp
)

CREATE TABLE e_habit
(
    habit_id bigSerial primary key,
    habit_name varchar(256),
    regularity varchar(256)
    user_id bigSerial REFERENCES e_user(user_id)
)

CREATE TABLE e_parameter
(
    param_id bigSerial primary key,
    param_name varchar(256),
    param_value int,
    param_description varchar(512)
    habit_id bigSerial REFERENCES e_habit(habit_id)
)

select *
from e_user usr
join e_habit hbt on usr.user_id = hbt.user_id
join e_parameter param on param.habit_id = hbt.habit_id;
