      String fileName = "nilesh.csv";
      try (Stream < String > lines = Files.lines(Paths.get(fileName))) {

          List <List<String>> values = lines.map(line - > Arrays.asList(line.split(",")))
                                       .collect(Collectors.toList());
          values.forEach(value - > System.out.println(value));

      } catch (IOException e) {
          e.printStackTrace();
      }

#

    A simple variation if you want to read from InputStream

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().map(line ->
                    Arrays.asList(line.split(",")))
                    .collect(Collectors.toList());
        }
    }
