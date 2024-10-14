package edu.icet.bo;

import edu.icet.bo.custom.impl.CustomerBoImpl;
import edu.icet.bo.custom.impl.EmployeeBoImpl;
import edu.icet.dao.custom.impl.SupplierDaoImpl;
import edu.icet.util.BoType;

public class BoFactory {
    private static BoFactory instance;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return instance!=null?instance:(instance=new BoFactory());
    }
    public <T extends SuperBo>T getBo(BoType type){
        switch (type){
            case EMPLOYEE:return (T)new EmployeeBoImpl();
            case CUSTOMER:return (T)new CustomerBoImpl();
            case SUPPLIER:return (T)new SupplierDaoImpl();
        }
        return null;
    }
}
