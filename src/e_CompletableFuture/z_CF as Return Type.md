
      private Optional<KinesisRequest> parseRequestPayload(ByteBuffer bb) {
         try {
           return Optional.ofNullable(gson.fromJson(newStringUtf8(bb.array()), KinesisRequest.class));
         } catch (JsonSyntaxException ex) {
           return Optional.empty();
         }
       }
   
