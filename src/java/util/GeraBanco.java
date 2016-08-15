package util;


import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraBanco {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure();
		SchemaExport se = new SchemaExport(conf);
		se.create(true, true);
	}
	
}
