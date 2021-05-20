-- Pelicula Le saut à la couverture
INSERT INTO crew (id) VALUES(1);

INSERT INTO principal(id, category, characters, job, name) VALUES(1, 'self', 'self', 'Director', 'Bruce Willis');

INSERT INTO principal(id, category, characters, job, name) VALUES(2, 'self', 'self', 'Writer', 'Bruce Willis');

INSERT INTO crew_directors(crew_id, directors_id) VALUES(1, 1);

INSERT INTO crew_writers(crew_id, writers_id) VALUES(1, 2);

INSERT INTO title_date(id, end_year, start_year) VALUES(1, null, '1930-01-01');

INSERT INTO title_information(id, original_title, primary_title, title_type) VALUES(1, 'Le saut à la couverture', 'Le saut à la couverture', 'short');

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('movie', '1', false, 60, null, null, 1, 1, 1);

INSERT INTO genre (id, name, production) VALUES (1, 'Documental', 'Cine');

INSERT INTO platform_content_genres (platform_content_title_id, genres_id) VALUES(1,1);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(1,2);

-----------------------------------------------------------------------------------------------------------------------------------
-- Pelicula The ball game
INSERT INTO crew (id) VALUES(2);

INSERT INTO principal(id, category, characters, job, name) VALUES(3, 'self', 'self', 'Actor', 'Bruce Willis');

INSERT INTO principal(id, category, characters, job, name) VALUES(4, 'self', 'self', 'Director', 'Bruce Willis');

INSERT INTO principal(id, category, characters, job, name) VALUES(5, 'self', 'self', 'Writer', 'Bruce Willis');

INSERT INTO crew_directors(crew_id, directors_id) VALUES(2, 4);

INSERT INTO crew_writers(crew_id, writers_id) VALUES(2, 5);

INSERT INTO title_date(id, end_year, start_year) VALUES(2, null, '1934-01-01');

INSERT INTO title_information(id, original_title, primary_title, title_type) VALUES(2, 'The Ball Game', 'The Ball Game', 'short');

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('movie', '2', false, 60, null, null, 2, 2, 2);

INSERT INTO genre (id, name, production) VALUES (2, 'Horror', 'Cine');

INSERT INTO platform_content_genres (platform_content_title_id, genres_id) VALUES(2,2);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(2,3);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(2,4);

---------------------------------------------------------------------------------------------------------------------------------
-- Pelicula Aladdin and the Wonderful Lamp'

INSERT INTO crew (id) VALUES(3);

INSERT INTO principal(id, category, characters, job, name) VALUES(6, 'self', 'self', 'Actor', 'Bruce Willis');

INSERT INTO principal(id, category, characters, job, name) VALUES(7, 'self', 'self', 'Actor', 'Bruce Willis');


INSERT INTO crew_directors(crew_id, directors_id) VALUES(3, 6);

INSERT INTO crew_writers(crew_id, writers_id) VALUES(3, 7);

INSERT INTO title_date(id, end_year, start_year) VALUES(3, null, '1995-01-01');

INSERT INTO title_information(id, original_title, primary_title, title_type) VALUES(3, 'Aladdin and the Wonderful Lamp', 'Aladdin and the Wonderful Lamp', 'short');

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('movie', '3', false, 60, null, null, 3, 3, 3);

INSERT INTO genre (id, name, production) VALUES (3, 'Action', 'Cine');

INSERT INTO platform_content_genres (platform_content_title_id, genres_id) VALUES(3,3);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(3,6);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(3,7);

---------------------------------------------------------------------------------------------------------------------------------
-- Series The Messenger Boy's Mistake

INSERT INTO crew (id) VALUES(4);

INSERT INTO principal(id, category, characters, job, name) VALUES(8, 'self', 'self', 'Writer', 'Bruce Willis');

INSERT INTO principal(id, category, characters, job, name) VALUES(9, 'self', 'self', 'Director', 'Bruce Willis');


INSERT INTO crew_directors(crew_id, directors_id) VALUES(4, 9);

INSERT INTO crew_writers(crew_id, writers_id) VALUES(4, 8);

INSERT INTO title_date(id, end_year, start_year) VALUES(4, null, '2020-01-01');

INSERT INTO title_information(id, original_title, primary_title, title_type) VALUES(4, 'Messenger Boy''s Mistake', 'Messenger Boy''s Mistake', 'short');

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('series', '4', false, 60, null, null, 4, 4, 4);

INSERT INTO genre (id, name, production) VALUES (4, 'Mistery', 'Netflix');

INSERT INTO platform_content_genres (platform_content_title_id, genres_id) VALUES(4,4);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(4,8);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(4,9);

-- episodes
INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('episode', '5', false, 60, 1, 1, 4, 4, 4);

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('episode', '6', false, 60, 2, 1, 4, 4, 4);

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('episode', '7', false, 60, 3, 1, 4, 4, 4);
---------------------
INSERT INTO platform_content_episodes (series_title_id, episodes_title_id) VALUES (4,5);
INSERT INTO platform_content_episodes (series_title_id, episodes_title_id) VALUES (4,6);
INSERT INTO platform_content_episodes (series_title_id, episodes_title_id) VALUES (4,7);


--- binding with platform content
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (1,1);
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (2,2);
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (3,3);
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (4,4);
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (5,5);
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (6,6);
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (7,7);

UPDATE platform_content SET binder_id = 1 WHERE title_id = '1';
UPDATE platform_content SET binder_id = 2 WHERE title_id = '2';
UPDATE platform_content SET binder_id = 3 WHERE title_id = '3';
UPDATE platform_content SET binder_id = 4 WHERE title_id = '4';
UPDATE platform_content SET binder_id = 5 WHERE title_id = '5';
UPDATE platform_content SET binder_id = 6 WHERE title_id = '6';
UPDATE platform_content SET binder_id = 7 WHERE title_id = '7';

------------------------------------------------------------------------------------------------------------------------
-- Reviews Ricardo
INSERT INTO review 
(review_type, id, date, description, full_description, language, like_dislike_score, origin_platform_name,
platform_user_id, rating, binder_id)
VALUES('premium', 1, '2021-04-15', 'La pelicula es mala', 'Muy mala pelicula', 'Spanish', 2, 'Netflix', '243', 3, 1);

INSERT INTO review
(review_type, id, date, description, full_description, language, like_dislike_score, origin_platform_name,
platform_user_id, rating, binder_id)
VALUES('premium', 2, '2021-04-23', 'Pelicula aburrida', 'Muy aburrida', 'Spanish', 1, 'Netflix', '243', 5, 2);
--------------------------------------------------------------------------------

-- Reviews nestor
INSERT INTO review 
(review_type, id, date, description, full_description, language, like_dislike_score, origin_platform_name,
platform_user_id, rating, user_reports, country, nickname, spoiler_alert, binder_id)
VALUES('free', 3, '2019-04-23', 'Excelente pelicula', '+5 y a favoritos', 'Spanish', 0, 'Amazon', '23', 0, 'r0|r1', 'Argentina', 'nestor123', false, 1);

-- binding with reviews
INSERT INTO platform_content_review_binder_reviews (platform_content_review_binder_id, reviews_id) VALUES (1,1);
INSERT INTO platform_content_review_binder_reviews (platform_content_review_binder_id, reviews_id) VALUES (1,3);
INSERT INTO platform_content_review_binder_reviews (platform_content_review_binder_id, reviews_id) VALUES (2,2);


