-- Le saut à la couverture
INSERT INTO crew (id) VALUES(1);

INSERT INTO principal(id, category, characters, job) VALUES(1, 'self', 'self', 'Director');

INSERT INTO principal(id, category, characters, job) VALUES(2, 'self', 'self', 'Writer');

INSERT INTO crew_directors(crew_id, directors_id) VALUES(1, 1);

INSERT INTO crew_writers(crew_id, writers_id) VALUES(1, 2);

INSERT INTO title_date(id, end_year, start_year) VALUES(1, null, '1930-03-10');

INSERT INTO title_information(id, original_title, primary_title, title_type) VALUES(1, 'Le saut à la couverture', 'Le saut à la couverture', 'short');

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('movie', 1, false, 60, null, null, 1, 1, 1);

INSERT INTO genre (id, name, production) VALUES (1, 'Documental', 'Cine');

INSERT INTO platform_content_genres (platform_content_title_id, genres_id) VALUES(1,1);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(1,2);

-----------------------------------------------------------------------------------------------------------------------------------
-- Pelicula The ball game
INSERT INTO crew (id) VALUES(2);

INSERT INTO principal(id, category, characters, job) VALUES(3, 'self', 'self', 'Actor');

INSERT INTO principal(id, category, characters, job) VALUES(4, 'self', 'self', 'Director');

INSERT INTO principal(id, category, characters, job) VALUES(5, 'self', 'self', 'Writer');

INSERT INTO crew_directors(crew_id, directors_id) VALUES(2, 4);

INSERT INTO crew_writers(crew_id, writers_id) VALUES(2, 5);

INSERT INTO title_date(id, end_year, start_year) VALUES(2, null, '1930-03-10');

INSERT INTO title_information(id, original_title, primary_title, title_type) VALUES(2, 'The Ball Game', 'The Ball Game', 'short');

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('movie', 2, false, 60, null, null, 2, 2, 2);

INSERT INTO genre (id, name, production) VALUES (2, 'Horror', 'Cine');

INSERT INTO platform_content_genres (platform_content_title_id, genres_id) VALUES(2,2);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(2,3);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(2,4);

---------------------------------------------------------------------------------------------------------------------------------
-- Pelicula Aladdin and the Wonderful Lamp'

INSERT INTO crew (id) VALUES(3);

INSERT INTO principal(id, category, characters, job) VALUES(6, 'self', 'self', 'Actor');

INSERT INTO principal(id, category, characters, job) VALUES(7, 'self', 'self', 'Actor');


INSERT INTO crew_directors(crew_id, directors_id) VALUES(3, 6);

INSERT INTO crew_writers(crew_id, writers_id) VALUES(3, 7);

INSERT INTO title_date(id, end_year, start_year) VALUES(3, null, '1995-03-10');

INSERT INTO title_information(id, original_title, primary_title, title_type) VALUES(3, 'Aladdin and the Wonderful Lamp', 'Aladdin and the Wonderful Lamp', 'short');

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('movie', 3, false, 60, null, null, 3, 3, 3);

INSERT INTO genre (id, name, production) VALUES (3, 'Action', 'Cine');

INSERT INTO platform_content_genres (platform_content_title_id, genres_id) VALUES(3,3);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(3,6);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(3,7);

---------------------------------------------------------------------------------------------------------------------------------
-- Series The Messenger Boy's Mistake

INSERT INTO crew (id) VALUES(4);

INSERT INTO principal(id, category, characters, job) VALUES(8, 'self', 'self', 'Writer');

INSERT INTO principal(id, category, characters, job) VALUES(9, 'self', 'self', 'Director');


INSERT INTO crew_directors(crew_id, directors_id) VALUES(4, 9);

INSERT INTO crew_writers(crew_id, writers_id) VALUES(4, 8);

INSERT INTO title_date(id, end_year, start_year) VALUES(4, null, '2020-05-10');

INSERT INTO title_information(id, original_title, primary_title, title_type) VALUES(4, 'Messenger Boy''s Mistake', 'Messenger Boy''s Mistake', 'short');

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('series', 4, false, 60, null, null, 4, 4, 4);

INSERT INTO genre (id, name, production) VALUES (4, 'Mistery', 'Netflix');

INSERT INTO platform_content_genres (platform_content_title_id, genres_id) VALUES(4,4);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(4,8);

INSERT INTO platform_content_principals (platform_content_title_id, principals_id) VALUES(4,9);

-- episodes
INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('episode', 5, false, 60, 1, 1, 4, 4, 4);

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('episode', 6, false, 60, 2, 1, 4, 4, 4);

INSERT INTO platform_content (platform_content, title_id, is_adult, runtime_minutes, episode_number, season_number, crew_id, title_date_id, title_information_id)
VALUES('episode', 7, false, 60, 3, 1, 4, 4, 4);
---------------------
INSERT INTO platform_content_episodes (series_title_id, episodes_title_id) VALUES (4,5);
INSERT INTO platform_content_episodes (series_title_id, episodes_title_id) VALUES (4,6);
INSERT INTO platform_content_episodes (series_title_id, episodes_title_id) VALUES (4,7);

------------------------------------------------------------------------------------------------------------------------
-- Reviews Ricardo

INSERT INTO review (review_type, id, date, description, full_description, language, like_dislike_score, origin_platform_name, platform_user_id, rating, user_reports, country, nickname, spoiler_alert)
VALUES('premium', 1, '2021-04-23', 'La pelicula es mala', 'Muy mala pelicula', 'Spanish', 2, 'Netflix', 243, 0, 1, 'Argentina', 'Ricardo123', false );

INSERT INTO review (review_type, id, date, description, full_description, language, like_dislike_score, origin_platform_name, platform_user_id, rating, user_reports, country, nickname, spoiler_alert)
VALUES('premium', 2, '2021-04-23', 'Pelicula aburrida', 'Muy aburrida', 'Spanish', 2, 'Netflix', 243, 0, 2, 'Argentina', 'Ricardo123', false );
--------------------------------------------------------------------------------

-- Reviews nestor

INSERT INTO review (review_type, id, date, description, full_description, language, like_dislike_score, origin_platform_name, platform_user_id, rating, user_reports, country, nickname, spoiler_alert)
VALUES('free', 3, '2019-04-23', 'Excelente pelicula', '+5 y a favoritos', 'Spanish', 2, 'Amazon', 243, 0, 2, 'Argentina', 'nestor123', false );


--- binding with platform content
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (1,1);
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (2,2);
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (3,3);
INSERT INTO platform_content_review_binder (id, platform_content_title_id) VALUES (4,4);

-- binding with reviews
INSERT INTO platform_content_review_binder_reviews (platform_content_review_binder_id, reviews_id) VALUES (1,1);
INSERT INTO platform_content_review_binder_reviews (platform_content_review_binder_id, reviews_id) VALUES (1,3);
INSERT INTO platform_content_review_binder_reviews (platform_content_review_binder_id, reviews_id) VALUES (2,2);
