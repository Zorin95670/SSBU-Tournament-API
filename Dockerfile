FROM postgres:9.6
COPY src/main/resources/db/0_init.sql                    /docker-entrypoint-initdb.d/
COPY src/main/resources/db/1a_insert_tournament_type.sql /docker-entrypoint-initdb.d/
COPY src/main/resources/db/1b_insert_character.sql       /docker-entrypoint-initdb.d/
COPY src/main/resources/db/9_user_grant.sql              /docker-entrypoint-initdb.d/
COPY src/main/resources/db/8_populate_demo.sql           /docker-entrypoint-initdb.d/
