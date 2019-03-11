Build db
mvn dockerfile:build

Start docker db
docker run -p 5432:5432 --rm -ti ssbu_db:0.0.1-SNAPSHOT

Connect to db
psql -h localhost -p 5432 -U postgres ssbu_tournament
