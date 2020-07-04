package cn.kangz.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import cn.kangz.dao.RecordDao;
import cn.kangz.pojo.Manager;
import cn.kangz.pojo.Record;

public class RecordDaoImpl implements RecordDao {
		
	@Override
	public boolean inputrecord(Manager m,Record r) {
		BufferedWriter bw = null;
		boolean flag=false;
		try {
			bw=new BufferedWriter(new FileWriter(new File("Processing_orders"+File.separator+m.getManager_id()+".txt"),true));
			bw.write(r.getManager_id()+"="+r.getOrder_id()+"="+r.getType()+"="+r.getDate()+"="+r.getMoney());
			bw.newLine();
			bw.flush();
			flag=true;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
		
	

	@Override
	public ArrayList<Record> ouputList(Manager m) {
		ArrayList<Record> list = new ArrayList<Record>();
		BufferedReader br = null;
		try {
			br= new BufferedReader(new FileReader(new File("Processing_orders"+File.separator+m.getManager_id()+".txt")));
			String line = null;
			while((line= br.readLine())!=null) {
				String[] datas = line.split("=");
				Record r= new Record();
				r.setManager_id(datas[0]);
				r.setOrder_id(datas[1]);
				r.setType(datas[2]);
				r.setDate(datas[3]);
				r.setMoney(datas[4]);
				
				list.add(r);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean inputrecordover(Manager m, ArrayList<Record> list) {
		BufferedWriter bw = null;
		boolean flag=false;
		try {	
			bw=new BufferedWriter(new FileWriter(new File("Processing_orders"+File.separator+m.getManager_id()+".txt")));
			for(Record r:list) {
			
				bw.write(r.getManager_id()+"="+r.getOrder_id()+"="+r.getType()+"="+r.getDate()+"="+r.getMoney());
				bw.newLine();
				bw.flush();
			}
			flag=true;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}



	@Override
	public boolean newfile(Manager m) {
		boolean flag = false;
		File file = new File("Processing_orders");
		file.mkdirs();
		if(m.getManager_id()==null||m.getManager_id().length()<0) {
			
		}else {
			File name = new File(file+File.separator+m.getManager_id()+".txt");
		try {
			name.createNewFile();
			flag=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return flag;
	}

}
