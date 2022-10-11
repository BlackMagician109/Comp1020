/**
* Name of class or program Exercise2_Submission
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh Ababzadeh
* ASSIGNMENT Exercise2
* @author Shivam Sharma, 7885183
* @version 11-10-2022
*
* PURPOSE: what is the purpose of your program?
*/

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
