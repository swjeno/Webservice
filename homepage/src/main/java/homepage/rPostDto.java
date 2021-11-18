package homepage;

import java.sql.Timestamp;

public class rPostDto {
        private String pnum;//id
        private String rpnum;//id
        private String rpname;//pw
		private String rpcontent;
        private String id;//�븰踰�

        public rPostDto(String pnum,String rpnum, String rpname, String rpcontent, String id) {
                this.pnum = pnum;
                this.rpnum = rpnum;
                this.rpname = rpname;
                this.rpcontent = rpcontent;
                this.id = id;
        }

        public rPostDto() {
        	
        	
        }
        
        public String getPnum() {
        	return pnum;
        }
        public String getrPnum() {
        	return rpnum;
        }
        public String getrPname() {
        	return rpname;
        }
        public String getrPcontent() {
        	return rpcontent;
        }
        public String getId() {
        	return id;
        }
        
        public void setPnum(String pnum) {
        	this.pnum = pnum;
        }
        public void setrPnum(String rpnum) {
        	this.rpnum = rpnum;
        }
        public void setrPname(String rpname) {
        	this.rpname = rpname;
        }
        public void setrPcontent(String rpcontent) {
        	this.rpcontent = rpcontent;
        }
        public void setId(String id) {
        	this.id = id;
        }
        
}