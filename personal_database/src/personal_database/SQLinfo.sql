SELECT anime.a_title, anime.release_date, anime.adaptation_of, cartoon.current_episode, cartoon.current_season, cartoon.network, mediaType.completed, mediaType.artwork, mediaType.summary 
FROM anime, cartoon, mediaType
WHERE anime.a_title ="Kill La Kill" AND c_title = anime.a_title AND title = anime.a_title;