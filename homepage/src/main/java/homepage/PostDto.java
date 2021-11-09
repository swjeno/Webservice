package homepage;

import java.sql.Timestamp;

public class PostDto {
        private String pnum;//id
        private String pname;//pw
		private String pcontent;
        private String id;//�븰踰�
        private Timestamp date;

        public PostDto(String pnum, String pname, String pcontent, String id, Timestamp date) {
                this.pnum = pnum;
                this.pname = pname;
                this.pcontent = pcontent;
                this.id = id;
                this.date = date;
        }

        public PostDto() {
        	
        	
        }
        
        public String getPnum() {
        	return pnum;
        }
        public String getPname() {
        	return pname;
        }
        public String getPcontent() {
        	return pcontent;
        }
        public String getId() {
        	return id;
        }
        public Timestamp getDate() {
        	return date;
        }
        

        public void setPnum(String pnum) {
        	this.pnum = pnum;
        }
        public void setPname(String pname) {
        	this.pname = pname;
        }
        public void setPcontent(String pcontent) {
        	this.pcontent = pcontent;
        }
        public void setId(String id) {
        	this.id = id;
        }
        public void setDate(Timestamp date) {
        	this.date = date;
        }
        
}