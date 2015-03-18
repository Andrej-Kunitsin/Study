package myNew;

import java.awt.Component;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Serializ {

	public void saveXML(File file, List<Component> list) {
		FileOutputStream zz = null;
		XMLEncoder xe = null;
		try {
			zz = new FileOutputStream(file);
			xe = new XMLEncoder(zz);
			xe.writeObject(list);
			xe.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			try {
				xe.close();
				zz.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<Component> openXML(File file) {
		FileInputStream reader = null;
		List<Component> list = null;
		XMLDecoder decoder = null;
		try {
			reader = new FileInputStream(file);
			decoder = new XMLDecoder(reader);
			list = (ArrayList<Component>) decoder.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				decoder.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public void saveJSON(File file, List<Component> list) {
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			writer.write(createJSON(list));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public List<Component> openJSON(File file) {
		List<Component> list = new ArrayList<Component>();
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(file));
			String str = reader.readLine();
			str = str.substring(1, str.length() - 1);
			
			String[] personArr = str.split("[},{]");
			for (int i = 0; i < personArr.length; i++)
			{
				System.out.println(personArr[i]);
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	private String createJSON(List<Component> list) {
		String string = "[";
		for (Component p : list) {
			string = string.concat("{");
			Field[] fields = p.getClass().getFields();
			for (Field f : fields) {
				f.setAccessible(true);
				try {
					string = string.concat("\"" + f.getName() + "\":"
							+ f.get(p) + ",");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			string = string.substring(0, string.length() - 1) + "},";
		}
		string = string.substring(0, string.length() - 1) + "]";
		System.out.println(string);
		return string;
	}

}
