# attendancesys
attendence system
1. Start applicaion and run below mysql query

INSERT INTO `attendancesys`.`user` (`password`, `username`, `role`) VALUES ('$2y$12$b.scTXUT8K/8u4TKDESgSeKfOhJbXbgpC3ld6ep593cDnST/LZMTq', 'sysadmin', 'admin');

Default username = sysadmin
Default password = 12345

1. At the begging you need to send request to server with your username and password.
http://localhost:8080/authenticate

{
	"username": "sysadmin",
	"password": "12345"

}

2. Expected Json Response

{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzeXNhZG1pbiIsImV4cCI6MTU3NDAwMjg5MCwiaWF0IjoxNTc0MDAyODMwfQ.MJ8wPZ65JyOJDBjWi9xBxsjmWehz4KtQTyipvTs_MDncR09_CjJrbayZsMiFFmnGwRRgB9U3WxrQ1LyNLS8gIA"
}

3. You have to add this json token for each subsequent request as x-authorization header.