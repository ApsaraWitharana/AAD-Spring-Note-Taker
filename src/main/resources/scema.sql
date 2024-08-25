# DROP DATABASE IF EXISTS noteTrakerAAD68;
#
# CREATE DATABASE IF NOT EXISTS  noteTrakerAAD68;
#
# SHOW DATABASES;
#
# USE noteTrakerAAD68;
#
#
# CREATE TABLE noteTraker (
#                             noteId VARCHAR(15) PRIMARY KEY,
#                             noteTitle VARCHAR(255) NOT NULL,
#                             noteDesc VARCHAR(255) NOT NULL,
#                             priorityLevel VARCHAR(255) NOT NULL,
#                             createDate BIGINT NOT NULL  -- Store the date as a timestamp
# );