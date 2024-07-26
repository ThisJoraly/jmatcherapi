CREATE TABLE users
(
    id       serial primary key,
    name     varchar(255) not null,
    email    varchar(255) not null,
    password varchar(255) not null,
    age      int          not null,
    gender   varchar(255) not null,
    location varchar(255) not null,
    bio      text         not null,
    photo    varchar(255) not null
);

CREATE TABLE matches
(
    id       serial primary key,
    user1_id int not null,
    user2_id int not null,
    foreign key (user1_id) references users (id),
    foreign key (user2_id) references users (id)
);

CREATE TABLE message
(
    id          serial primary key,
    sender_id   int  not null,
    receiver_id int  not null,
    message     text not null,
    foreign key (sender_id) references users (id),
    foreign key (receiver_id) references users (id)
);

CREATE TABLE interest
(
    id   serial primary key,
    name varchar(255) not null
);

CREATE TABLE userinterest
(
    id          serial primary key,
    user_id     int,
    interest_id int,
    foreign key (user_id) references users (id),
    foreign key (interest_id) references interest (id)
);