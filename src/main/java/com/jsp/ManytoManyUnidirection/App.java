package com.jsp.ManytoManyUnidirection;

import java.util.ArrayList;
import java.util.List;

import com.jsp.ManytoManyUnidirection.dao.PersonDao;
import com.jsp.ManytoManyUnidirection.dta.Language;
import com.jsp.ManytoManyUnidirection.dta.Person;

public class App 
{
    public static void main( String[] args )
    {
       PersonDao persondao=new PersonDao();
       
       Person p1=new Person();
       p1.setName("Omkar");
       p1.setAge(26);
       
       Person p2=new Person();
       p2.setName("Krishna");
       p2.setAge(89);
       
       Language lang1=new Language();
       lang1.setName("kannada");
       lang1.setOrigin("Karnataka");
       
       Language lang2 =new Language();
       lang2.setName("Telugu");
       lang2.setOrigin("Andhra pradesh");
       
       
       List<Language>l1=new ArrayList<Language>();
       l1.add(lang1);
       l1.add(lang2);
       
       List<Language>l2=new ArrayList<Language>();
       l2.add(lang2);
       
       p1.setList(l1);
       p2.setList(l2);
       
       persondao.saveperson(p1);
       persondao.saveperson(p2);
       
       persondao.saveLanguage(lang1);
       persondao.saveLanguage(lang2);
       
    }
}
