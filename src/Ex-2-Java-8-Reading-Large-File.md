          File Handling in Java : https://funnelgarden.com/java_read_file/

          Source : https://stackabuse.com/reading-a-file-line-by-line-in-java/

## PROBLEM  : 

    You have to parse a large CSV file (~90MB), practically read the file, and 
     create one Java object for each of the lines. In real life, the CSV file contains around 380,000 lines.

## SOLUTION : 

     private List<YourJavaItem> processInputFile(String inputFilePath) {

              List<YourJavaItem> inputList = new ArrayList<YourJavaItem>();

              try{

                File inputFile = new File(inputFilePath);

                InputStream fileInputStream = new FileInputStream(inputFile);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));


                inputList = bufferedReader.lines()
                            .skip(1)                   // skip the header of the csv
                            .map(mapToItem)
                            .collect(Collectors.toList());

                br.close();

              } catch (FileNotFoundException|IOException e) {

              }

              return inputList ;
      }

##
          Here,
          
           lines()        : returns a stream object.

           skip(1)        : skips the first line in the CSV file, which in this case is the header of the file.

           map(mapToItem) : calls the mapToItem  function for each line in the file.

           collect(Collectors.toList()) : creates a list containing all the items created by mapToItem  function.

           OBSERVATION : 
           From the testing I've done, it seems that reading a 90 MB CSV file using the way described above 
           will take around 700 ms when running from inside Eclipse. 

