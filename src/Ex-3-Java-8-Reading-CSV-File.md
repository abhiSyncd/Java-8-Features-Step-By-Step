      String fileName = "nilesh.csv";
      try (Stream < String > lines = Files.lines(Paths.get(fileName))) {

          List <List<String>> values = lines.map(line - > Arrays.asList(line.split(",")))
                                       .collect(Collectors.toList());
          values.forEach(value - > System.out.println(value));

      } catch (IOException e) {
          e.printStackTrace();
      }
