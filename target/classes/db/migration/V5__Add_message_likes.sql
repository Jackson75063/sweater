create table message_likes(

    user_id bigint not null REFERENCES  usr,
    message_id BIGINT not NULL REFERENCES  message,
    PRIMARY KEY (user_id,message_id)
)