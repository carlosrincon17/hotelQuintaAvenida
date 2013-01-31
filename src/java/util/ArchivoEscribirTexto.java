package util;
import java.io.*;

/**
 *
 * @author Henry
 */
public class ArchivoEscribirTexto
{

	private String filename;
	private PrintWriter escr;

        /**
         *
         * @param filename
         */
        public ArchivoEscribirTexto(String filename)
		{

			try{
				this.filename=filename;
				escr= new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			}
			catch( IOException e)
			{}
		}

        /**
         *
         * @param msg
         * @throws IOException
         */
        public void println(String msg) throws IOException
		{
                    String [] men = msg.split("\n");
                    for(String m:men)
                    escr.println(m);


		}


        /**
         *
         * @param msg
         * @throws IOException
         */
        public void println(int msg) throws IOException
		{
			escr.println(msg);

		}


        /**
         *
         * @param msg
         * @throws IOException
         */
        public void println(float msg) throws IOException
		{
			escr.println(msg);
		}


        /**
         *
         * @param msg
         * @throws IOException
         */
        public void println(byte msg) throws IOException
		{
			escr.println(msg);
		}

        /**
         *
         * @param msg
         * @throws IOException
         */
        public void println(boolean msg) throws IOException
		{
			escr.println(msg);
		}

        /**
         *
         * @param msg
         * @throws IOException
         */
        public void println(short msg) throws IOException
		{
			escr.println(msg);
		}


        /**
         *
         * @param msg
         * @throws IOException
         */
        public void println(double msg) throws IOException
		{
			escr.println(msg);
		}

        /**
         *
         * @param msg
         * @throws IOException
         */
        public void println(char msg) throws IOException
		{
			escr.println(msg);
		}


        /********************************print****************************
         * @param <T>
         * @param datos
         */
	public <T> void escribir(T datos)
		{
                    try{
                   escr.println(datos.toString());
                    }
                    catch(Exception e)
			{
                        System.err.print(e.getMessage());
                        }

		}



        /**
         *
         */
        public void close()
		{
                    try
                    {
			this.escr.close();
                    }
                    catch(Exception e)
			{
                        System.err.print(e.getMessage());
                        }
		}

}