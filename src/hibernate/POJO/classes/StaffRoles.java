package hibernate.POJO.classes;
// Generated Mar 24, 2014 1:47:58 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * StaffRoles generated by hbm2java
 */
public class StaffRoles  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set staffs = new HashSet(0);

    public StaffRoles() {
    }

	
    public StaffRoles(String name) {
        this.name = name;
    }
    public StaffRoles(String name, Set staffs) {
       this.name = name;
       this.staffs = staffs;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getStaffs() {
        return this.staffs;
    }
    
    public void setStaffs(Set staffs) {
        this.staffs = staffs;
    }




}

