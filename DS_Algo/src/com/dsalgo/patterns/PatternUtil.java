package com.dsalgo.patterns;

/**
 * An Utility that builds different patterns
 * @author Dvijay
 *
 */
public class PatternUtil {
	
	private int defaultSize = 7;

	private String[][] designArray = new String[defaultSize][defaultSize];
	
	private StringBuilder design = new StringBuilder();
	
	/**
	 * 
	 * @return the pattern design array <br/>
	 * Simply traverse the array in the following way to print the pattern
	 * <pre>for(int i=0;i&ltarr.length;i++) {
 for(int j=0;j&ltarr[i].length;j++) {
  System.out.print(arr[i][j]);
  }
  System.out.println();
 }</pre> 
	 */
	public String[][] getDesignArr() {
		return designArray;
	}

	/**
	 * Initializes the pattern with the given size 
	 * @param size  <pre>  1 &lt size &lt 20</pre>
	 * <pre> size value will always be converted to odd integer for better design </pre>
	 * @throws IllegalArgumentException
	 */
	public PatternUtil(int size) {
		if (size <= 1 || size >= 20)
			throw new IllegalArgumentException();
		if (size % 2 == 0)
			size++;
		this.defaultSize = size;
		this.designArray = new String[this.defaultSize][this.defaultSize];
	}

	/**
	 * Initializes the pattern with default size of 7
	 */
	public PatternUtil() {
	}

	public static void main(String[] args) {

		PatternUtil p = new PatternUtil();
		System.out.println(p.pyramid());
		String[][] arr = p.getDesignArr();
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * <pre>*           *</pre>
	 * <pre>* *       * *</pre>
	 * <pre>* * *   * * *</pre>
	 * <pre>* * * * * * *</pre>
	 * <pre>* * *   * * *</pre>
	 * <pre>* *       * *</pre>
	 * <pre>*           *</pre>
	 * 
	 * @return the pattern
	 */
	public String designInfinityTriangle() {
		resetDesign();
		for (int i = 0; i < designArray.length; i++) {
			for (int j = 0; j < designArray[i].length; j++) {
				if ((i >= j && j <= (designArray.length / 2) - 1 && i + j <= designArray.length - 1)
						|| (i + j >= designArray.length - 1 && j >= (designArray.length / 2) - 1 && i <= j)) {
					design.append("* ");
					designArray[i][j] = "* ";
				} else {
					design.append("  ");
					designArray[i][j] = "  ";
				}
			}
			design.append("\n");
		}
		return design.toString();
	}
	
	/**
	 * <pre> *           *
	 * * *       * *
	 * * * *   * * *
	 * * * * * * * *
	 * * * * * * * *
	 * * * * * * * *
	 * * * * * * * *</pre>
	 * 
	 * @return the pattern
	 */
	public String designV() {
		resetDesign();
		for (int i = 0; i < designArray.length; i++) {
			design.append(" ");
			for (int j = 0; j < designArray[i].length; j++) {
				if ((i - j >= 0) || (i + j >= designArray.length - 1)) {
					design.append("* ");
					designArray[i][j] = "* ";
				} else {
					design.append("  ");
					designArray[i][j] = "  ";
				}
			}
			design.append("\n");
		}
		return design.toString();
	}

	/**
	 * <pre>		* * * * * * * 
	 *		 * * * * * *   
	 *		  * * * * *     
	 *		   * * * *       
	 *		    * * *         
	 *		     * *           
	 *		      *
	 *</pre>
	 * @return the pattern
	 */
	public String inversePyramid() {
		resetDesign();
		for (int i = 0; i < designArray.length; i++) {
			String s = "";
			for (int k = 0; k <= i; k++) {
				s = s + " ";
			}
			design.append(s);
			for (int j = 0; j < designArray[i].length; j++) {
				if (i + j <= designArray.length - 1) {
					design.append("* ");
					designArray[i][j] = "* ";
				}
				else {
					design.append("  ");
					designArray[i][j] = "  ";
				}
			}
			design.append("\n");
		}
		return design.toString();
	}
	
	/**
	 * <pre>   	  *             
     *  	 * *           
     * 	* * *         
    *      * * * * *       
   *     * * * * * *     
	 * </pre>
	 * 
	 * @return the pattern
	 */
	public String pyramid() {
		resetDesign();
		for (int i = 0; i < designArray.length; i++) {
			String s = "";
			for (int k = designArray.length - i - 1; k >= 0; k--)
				s = s + " ";
			design.append(s);
			for (int j = 0; j < designArray[i].length; j++) {
				if (i - j >= 0) {
					design.append("* ");
					if (j == 0) {
						designArray[i][j] = s + "* ";
					} else {
						designArray[i][j] = "* ";
					}
				} else {
					design.append("  ");
					designArray[i][j] = "  ";
				}
			}
			design.append("\n");
		}
		return design.toString();
	}

	/**
	 *  	<pre>   *
	 *  **
	 * ***</pre>
	 * 
	 * @return the pattern
	 */
	public void rightOrthogonalTriangle() {
		resetDesign();
		for (int i = 0; i < designArray.length; i++) {
			for (int j = 0; j < designArray[i].length; j++) {
				if (i + j >= designArray.length - 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	/**
	 * <pre> ***
	 * **
	 * *</pre>
	 * 
	 * @return the pattern
	 */
	public void inverseLeftOrthogonalTriangle() {
		for (int i = 0; i < designArray.length; i++) {
			for (int j = 0; j < designArray[i].length; j++) {
				if (i + j <= designArray.length - 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	/**
	 * <pre>***</pre>
	 * <pre> **</pre>
	 * <pre>  *</pre>
	 */
	public void inverseRightOrthogonalTriangle() {
		for (int i = 0; i < designArray.length; i++) {
			for (int j = 0; j < designArray[i].length; j++) {
				if (i - j <= 0)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	/**
	 * <pre>*  </pre>
	 * <pre>** </pre>
	 * <pre>***</pre>
	 */
	public void leftOrthogonalTriangle() {
		for (int i = 0; i < designArray.length; i++) {
			for (int j = 0; j < designArray[i].length; j++) {
				if (i - j >= 0)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	public void designX() {
		for (int i = 0; i < designArray.length; i++) {
			for (int j = 0; j < designArray[i].length; j++) {
				if (i == j)
					System.out.print("* ");
				else if (i + j == designArray.length - 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	public void squareBorder() {
		for (int i = 0; i < designArray.length; i++) {
			for (int j = 0; j < designArray[i].length; j++) {
				if (i == 0 || i == designArray.length - 1) {
					System.out.print("* "); 	// horizontal border lines
				} else if (j == 0 || j == designArray[i].length - 1) {
					System.out.print("* "); 	// vertical border lines
				} else {
					System.out.print("  "); 	// rest
				}
			}
			System.out.println();
		}
	}

	public void diagonal() {
		for (int i = 0; i < designArray.length; i++) {
			for (int j = 0; j < designArray[i].length; j++) {
				if (i == j)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	public void square() {
		for (int i = 0; i < designArray.length; i++) {
			for (int j = 0; j < designArray[i].length; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private void resetDesign() {
		this.designArray = new String[this.defaultSize][this.defaultSize];
		this.design.setLength(0);
	}
}
