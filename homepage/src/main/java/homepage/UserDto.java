package homepage;

import java.sql.Timestamp;

public class UserDto {
        private String id;//id
        private String pw;//pw
		private String name;
        private String snum;//ÇÐ¹ø
        private Timestamp date;

        public UserDto(String id, String pw, String name, String snum, Timestamp date) {
                this.id = id;
                this.pw = pw;
                this.name = name;
                this.snum = snum;
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
        public String getSnum() {
        	return snum;
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
        public void setSnum(String snum) {
        	this.snum = snum;
        }
        public void setDate(Timestamp date) {
        	this.date = date;
        }
        
}