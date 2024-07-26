INSERT INTO users (name, email, password, age, gender, location, bio, photo)
VALUES ('John Doe', 'johndoe@example.com', 'password123', 25, 'Male', 'New York',
        'I am a software engineer with a passion for hiking and traveling.', 'johndoe.jpg'),
       ('Jane Smith', 'janesmith@example.com', 'password456', 30, 'Female', 'Los Angeles',
        'I am a teacher who loves reading and cooking in my free time.', 'janesmith.jpg'),
       ('Bob Johnson', 'bobjohnson@example.com', 'password789', 35, 'Male', 'Chicago',
        'I am a musician who enjoys playing guitar and going to concerts.', 'bobjohnson.jpg');

INSERT INTO matches (user1_id, user2_id)
VALUES (1, 2),
       (2, 3),
       (1, 3);

INSERT INTO message (sender_id, receiver_id, message)
VALUES (1, 2, 'Hi Jane, I saw your profile and thought we might have some common interests. Would you like to chat?'),
       (2, 3,
        'Hey Bob, I saw your profile and thought we might have some common interests. Would you like to meet up?'),
       (1, 3,
        'Hey Bob, I saw your profile and thought we might have some common interests. Would you like to collaborate on a project?');

INSERT INTO interest (name)
VALUES ('Hiking'),
       ('Reading'),
       ('Music');

INSERT INTO userinterest (user_id, interest_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);