package homepage;

import java.sql.Timestamp;

public class UserDto {
        private String id;
        private String pw;
        private String name;
        private String email;
        private String address;
        private Timestamp date;

        public UserDto(String id, String pw, String name, String email, String address, Timestamp date) {
                this.id = id;
                this.pw = pw;
                this.name = name;
                this.email = email;
                this.address = address;
                this.date = date;
        }

        public UserDto() {
        	
        	
        }

        public String getId() {
        	return id;
        }
        public String getPw() {
        	return pw;
        }
        public String getName() {
        	return name;
        }
        public String getEmail() {
        	return email;
        }
        public String getAddress() {
        	return address;
        }
        public Timestamp getDate() {
        	return date;
        }
        
        public void setId(String id) {
        	this.id = id;
        }
        public void setPw(String pw) {
        	this.pw = pw;
        }
        public void setName(String name) {
        	this.name = name;
        }
        public void setEmail(String email) {
        	this.email = email;
        }
        public void setAddress(String address) {
        	this.address = address;
        }
        public void setDate(Timestamp date) {
        	this.date = date;
        }
        

        // getter, setter 생략
}