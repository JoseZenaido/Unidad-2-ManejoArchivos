/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

/**
 *
 * @author ZENAIDO-PC
 */
public class DevelogSql {
    
     private int id;
    private String created;
    private String  sql0;
    private String sql1;
    private String  params;
    private String  tracer;
    private String timer;
    
    
    
    public DevelogSql(int id,
            String created, 
            String sql0,String sql1,String params,String tracer,String timer){
        this.id=id;
        this.created=created;
        this.sql0=sql0;
        this.sql1=sql1;
        this.params=params;
        this.tracer=tracer;
        this.timer=timer;
                
        
    }
    
    public DevelogSql(){
        this(0,"","","","","","");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSql0() {
        return sql0;
    }

    public void setSql0(String sql0) {
        this.sql0 = sql0;
    }

    public String getSql1() {
        return sql1;
    }

    public void setSql1(String sql1) {
        this.sql1 = sql1;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getTracer() {
        return tracer;
    }

    public void setTracer(String tracer) {
        this.tracer = tracer;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "Develogsql{" + "id=" + id + ", created=" + created + ", sql0=" + sql0 + ", sql1=" + sql1 + ", params=" + params + ", tracer=" + tracer + ", timer=" + timer + '}';
    }
    
    
    
}
