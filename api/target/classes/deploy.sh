docker build -t api .
docker run -p 8020:8020 -t -dit --restart=always api