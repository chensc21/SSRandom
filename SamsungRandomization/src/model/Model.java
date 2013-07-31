/**
 * @author Team Snipers (Team 1)
 * Jan 17, 2013
 */

package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Model {
	public static final String TEMP_PATH = "D:\\";
	
	private RandomizationDAO randomizationDAO;

	public Model(ServletConfig config) throws ServletException {
		randomizationDAO = new RandomizationDAO(TEMP_PATH);
	}

	public RandomizationDAO getRandomizationDAO() {
		return randomizationDAO;
	}
}
