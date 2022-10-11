import java.io.*;

public class Exercise2 {
   public static void main(String[] args) {
      BufferedReader input;
      String title, ratingText, outOfText;
      double rating = 0.0;
      double outOf = 0.0;

      Review[] movies = new Review[100];
      int size = 0;
      Review match;

      try {
         input = new BufferedReader(new FileReader("movies.txt"));

         title = input.readLine();
         while (title != null) {
            ratingText = input.readLine();
            outOfText = input.readLine();
            try {

               rating = Double.parseDouble(ratingText);
               outOf = Double.parseDouble(outOfText);
               rating = (rating/outOf)*10;

               // if the conversion failed and the code below was not in the
               // "try" block, the rating variable would contain the rating of
               // the <em>previous</em> movie we read in (bad data)
               match = findReview(movies, size, title);
               if (match == null) {
                  // movie that was not previously listed
                  movies[size] = new Review(title, rating);
                  size++;
               } else {
                  // this movie was already reviewed at least once
                  match.addRating(rating);
               }

            } catch (NumberFormatException nfe) {
               System.out.println("Invalid rating: " + ratingText);
            }

            title = input.readLine();
         }

         input.close();
      } catch (IOException ioe) {
         System.out.println(ioe.getMessage());
      }

      for (int i = 0; i < size; i++) {
         System.out.println(movies[i]);
      }

      System.out.println("\nFinished processing.");
   }

   public static Review findReview(Review[] movies, int size, String title) {
      Review result = null;
      int pos;

      pos = 0;
      while (pos < size && result == null) {
         if (movies[pos].matchTitle(title)) {
            result = movies[pos];
         } else {
            pos++;
         }
      }

      return result;
   }
}

class Review {
   private String title;
   private double totalRating;
   private int reviewCount;

   public Review(String title, double rating) {
      this.title = title;
      totalRating = rating;
      reviewCount = 1;
   }

   public void addRating(double rating) {
      totalRating += rating;
      reviewCount++;
   }

   public boolean matchTitle(String otherTitle) {
      // returns true if this movie's title matches otherTitle
      return title.equals(otherTitle);
   }

   public String toString() {
      return title + " (rating: " + (totalRating / reviewCount) + ")";
   }
}
