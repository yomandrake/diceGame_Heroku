INSERT INTO `player` (`player_id`, `player_log_name`, `player_name`, `player_reg_date`,`uuid`) VALUES
(1, '5toBeatle', 'Juan', '2020-05-14T14:15:58.721',  'uuidString1'),
(2, 'Robb', 'Roberta', '2020-05-14T14:15:58.722',  'uuidString2'),
(3, 'Pep', 'Pepo', '2020-05-14T14:15:58.723',  'uuidString3'),
(4, 'Kike', 'Luisa','2020-05-14T14:15:58.724',  'uuidString4'),
(5, 'Jhonny', 'Jhon', '2020-05-14T14:15:58.725',  'uuidString5');

INSERT INTO `games` (`game_id`, `dice1`, `dice2`, `dice3`, `dice4`, `game_date_time`, `is_win`, `player_id`, `player_player_id`) VALUES
(1, 1, 4, 0, 3, '2020-05-14T18:41:26.529', 0, 3, 3),
(2, 5, 2, 1, 0, '2020-05-14T18:41:26.888', 0, 3, 3),
(3, 2, 4, 0, 6, '2020-05-14T18:41:31.446', 0, 4, 4),
(4, 6, 3, 3, 6, '2020-05-14T18:41:36.307', 0, 5, 5),
(5, 0, 4, 6, 3, '2020-05-14T18:41:36.883', 1, 5, 5),
(6, 4, 6, 0, 5, '2020-05-14T18:36:44.414', 0, 1, 1),
(7, 0, 3, 5, 0, '2020-05-14T18:36:47.138', 0, 1, 1),
(8, 0, 0, 4, 0, '2020-05-14T18:36:48.671', 0, 1, 1),
(9, 5, 2, 4, 1, '2020-05-14T18:36:54.593', 0, 1, 1),
(10, 1, 4, 0, 2, '2020-05-14T18:39:48.724', 0, 2, 2),
(11, 5, 5, 2, 4, '2020-05-14T18:40:00.582', 1, 2, 2),
(12, 6, 1, 1, 5, '2020-05-14T18:41:25.140', 0, 3, 3),
(13, 5, 6, 3, 0, '2020-05-14T18:41:25.741', 1, 3, 3),
(14, 0, 5, 6, 2, '2020-05-14T18:41:26.194', 1, 3, 3),
(15, 1, 4, 0, 3, '2020-05-14T18:41:26.521', 0, 3, 3),
(16, 1, 1, 1, 1, '2020-05-14T18:41:26.882', 1, 3, 3),
(17, 1, 1, 1, 1, '2020-05-14T18:41:31.443', 1, 4, 4),
(18, 1, 1, 1, 1, '2020-05-14T18:41:36.304', 1, 5, 5),
(19, 1, 1, 1, 1, '2020-05-14T18:41:36.885', 1, 5, 5),
(20, 4, 6, 5, 5, '2020-05-14T18:36:44.416', 1, 1, 1),
(21, 0, 3, 5, 5, '2020-05-14T18:36:47.137', 1, 1, 1),
(22, 0, 0, 4, 0, '2020-05-14T18:36:48.678', 0, 1, 1),
(23, 5, 2, 4, 1, '2020-05-14T18:36:54.599', 0, 1, 1),
(24, 1, 4, 0, 2, '2020-05-14T18:39:48.734', 0, 2, 2),
(25, 5, 5, 1, 4, '2020-05-14T18:40:00.586', 1, 2, 2),
(26, 6, 1, 1, 5, '2020-05-14T18:41:25.145', 0, 3, 3),
(27, 5, 6, 3, 5, '2020-05-14T18:41:25.746', 1, 3, 3),
(28, 0, 5, 6, 6, '2020-05-14T18:41:26.197', 1, 3, 3),
(29, 1, 4, 0, 2, '2020-05-14T18:39:48.725', 0, 2, 2),
(30, 3, 5, 6, 6, '2020-05-14T18:41:26.196', 1, 3, 3);



-- create table users(
--   username varchar_ignorecase(50) not null primary key,
--   password varchar_ignorecase(50) not null,
--   enabled boolean not null);
-- 
-- create table authorities (
--   username varchar_ignorecase(50) not null,
--   authority varchar_ignorecase(50) not null,
--   constraint fk_authorities_users foreign key(username) references users(username));
-- 
-- create unique index ix_auth_username on authorities (username,authority);
-- 
-- INSERT INTO users (username, password, enabled)
-- 	values ('user',
-- 		'pass',
-- 		true
-- 		);
-- 
-- INSERT INTO users (username, password, enabled)
-- 	values ('admin',
-- 		'pass',
-- 		true
-- 		);
-- 
-- INSERT INTO authorities (username, authority)
-- 	values ('user','ROLE_USER');
-- 
-- INSERT INTO authorities (username, authority)
-- 	values ('admin','ROLE_ADMIN');