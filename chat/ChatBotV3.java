/*
I ran into several challenges whem making this program. My toughest challenge
was trying to figure out what method to use to solve the third problem.
I had an intial idea, but I did not know where to put it into the code.
I had to keep moving parts of my code to different methods to achieve different
results. My persona is based on my posse mentor. I chose this because I usually
come to my posse mentor for different reasons. We talk about academics, social life,
my posse, etc. Eventhough this is a silly program with silly responses, this is similates the one on one
meetings with a posse mentor. If I had more time for this project, I would
try to refactor the methods even more.
*/


package chat;

import java.util.Scanner;
import lib.StringArray;

public class ChatBotV3
{
  /**
  carry on a conversation with the user about their personal issues
  @param args an array of Strings which we ignore
  */
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Hey! I am your Posse Mentor!");
    System.out.println("What do you want to talk about in today's one-on-one?");
    boolean done=false;
    int n=0;
    String [] history=new String [1000];

    while (!done)
    {
      String userResponse = scanner.nextLine();
      String[] words = userResponse.split("\\s+");

     if (Math.random()>0.5)
      {
        recordHistory( n, history, userResponse);
        System.out.println( gethistory(history));
        if(userResponse.equals("yes"))
        {
          generateResponse(words);
        }
        else if(userResponse.equals("no"))
        {
          System.out.print("How do you really feel?");
        }
      }
      else
      {
        String myResponse = generateResponse(words);
        System.out.printf("%s%n%n",myResponse);
      }

      done = userResponse.equals("bye");
    }
  }
  /*@params[int n, String [] history, String userResponse][this method
  takes the user's response and add it to the history array. n which is the
  incates the index of the reponse in the history array.n is incremented.]
  @return[void is the return type]
*/
public static void recordHistory(int n, String [] history, String userResponse)
{
  while(n<1000)
  {
    history[n]=userResponse;
    n++;
  }
}
/*@params[ String [] history][this method chooses a random respponse in the history
array and returns it. ]
@return[String]
*/
public static String gethistory(String [] history)
{
  return "Earlier you had said. " + StringArray.pickRandom(history)+ " Is this still true? ";
}
/*@params[ String [] words, String [] keywords][this method contains a
for each loop that goes through the array of words and goes through each of the
keywords. It returs true if the word equals the keyword, else it is false.]
@return[boolean]
*/
public static boolean intersects(String [] words,String [] keywords)
{
  for(String s: words)
  {
    for(String y:keywords)
    {
      if(s.equals(y))
      {
        return true;
      }
    }
  }
  return false;
}
  /**
    generates a String in response to a user response
    passed in as an array of words
    @param words the user's response
    @return a string responding to the user's words
  */
  public static String generateResponse(String[] words)
  {
    if (words.length <=2)
    {
      // respond to a short response
      return StringArray.pickRandom(shortResponses);
    }
    else if (StringArray.intersects(words,familyWords))
    {
      return StringArray.pickRandom(familyResponses);
    }
    else if (StringArray.intersects(words,extracurricularActivitiesWords))
    {
      return StringArray.pickRandom(extracurricularActivitiesResponses);
    }
    else if (StringArray.intersects(words,wellBeingAndHealthWords))
    {
      return StringArray.pickRandom(wellBeingAndHealthResponses);
    }
    else if (StringArray.intersects(words,academicWords))
    {
      return StringArray.pickRandom(academicResponses);
    }
    else if (StringArray.intersects(words,friendsWords))
    {
      return StringArray.pickRandom(friendsResponses);
    }
    else if (StringArray.intersects(words,posseWords))
    {
      return StringArray.pickRandom(posseResponses);
    }
    else if (StringArray.intersects(words,jokeQuestions))
    {
      return StringArray.pickRandom(jokeAnswers);
    }
    else if (StringArray.intersects(words,adviceQuestions))
    {
      return StringArray.pickRandom(adviceAnswers);
    }
    else if (StringArray.intersects(words,personalQuestions))
    {
      return StringArray.pickRandom(personalAnswers);
    }
   else if (Math.random() > 0.5)
    {

      return StringArray.pickRandom(generalQuestions);
    }
   else
    {
      // the rest of the time pick a general response
      return StringArray.pickRandom(generalResponses);
    }
}





  /**
    an array of generic responses to a user comment
    @return[String []]
  */
  public static String[] generalResponses =
     {
       "Interesting. Please go on ...",
       "I see. Can you tell me more?",
       "Why don't you tell me about your mother.",
       "Have you spoken to your father out this?",
       "Is that right?",
       "What?",
       "I'm confused.",
       "I don't like where this conversation is headed.",
       "I dont want to talk about this anymore. Go away!",
       "Remember this is a confidential conversation"
     };

   /**
     an array of responses to a short user comment
   */
   public static String[] shortResponses =
   {
     "Please go on.",
     "I can tell you have more to say about this.",
     "Are you getting annoyed or angry?",
     "And....",
     "I can't help you unless you open up.",
     "You need to trust me if we are going to make any progress.",
     "I got this.",
     "I give the best advice",
     "I am you Posse Mentor.",
     "You should not talk to me about this."
   };

   /**
     an array of general questions used to change the subject
   */
   public static String[] generalQuestions =
   {
     "If you could fix one thing in your life, what would it be?",
     "Tell me about the happiest time in your life.",
     "Tell me about your first memory.",
     "If you could go anywhere next week, where would you go?",
     "How do you deal with frustration, when things aren't going as you want?"
    };
   public static String[] jokeQuestions=
    {
     "funny", "laugh", "chuckle","giggle", "hoot", "joke","hilarious"
    };
   public static String[] adviceQuestions=
    {
     "help", "advice", "struggling", "counsel", "coach", "assistance"
    };
   public static String[] personalQuestions=
    {
     "name", "birthday", "city", "state", "yourself", "personal"
    };

   public static String[] jokeAnswers=
    {
     "Q: What does a nosey pepper do? A: Gets jalapeno business",
     "Q: What do you call a fake noodle? A: An Impasta",
     "Q: What do you call an alligator in a vest? A: An Investigator"
    };
   public static String[] adviceAnswers=
    {
     "Go for a walk.",
     "Transfer to another school",
     "Stop Overreacting!"
    };
   public static String[] personalAnswers=
    {
     "My name is Shabreka Thomas.",
     "I am from Georgia",
     "My birthday is August 19,1999"
    };
  /**
    an array of words related to family, that lead to a "familyReponse"
  */
   public static String[] familyWords = {"mom","dad","mother","father",
     "brother","sister"};

  /**
    an array of responses to sentences that contain a family reference
  */
    public static String[] familyResponses =
     {
      "Tell me about your mom.",
      "What do you like doing with your Dad?",
      "What do your parents do for work?",
      "Who are you legal guardians?",
      "You should tell your parents about this.",
      "How does your mom feel about this.",
      "I love your parents!!!",
      "What happened?",
      "Have you called your family?",
      "Are you close with your family?"
     };

     public static String[] academicWords =
     {
      "project","professor","teacher", "school", "academics", "grades", "GPA",
      "teacher evaluations","finals", "midterms", "tests","quizzes", "homework",
      "readings"
     };
     public static String[] academicResponses =
     {
      "Do not worry. It will get better.",
      "Try talking to your academice advisor.",
      "Go to your teachers office hours.",
      "This is your first year. You are adjusting to the workload.",
      "Go to Latte and use the resources that are there.",
      "Reach out to your TA.",
      "Check the email that I sent you about the tutoring resources.",
      "Ask others who took that same class.",
      "Make sure that you are on track to graduate.",
      "Have you spoken to your teacher or your TA's?"};
     public static String[] wellBeingAndHealthWords =
     {
      "sick","stressed","depressed", "homesick", "pressured", "tired", "happy",
       "angry","excited", "anxious", "feeling","nervous", "worried"
     };
     public static String[] wellBeingAndHealthResponses =
     {
      "Take three deep breaths.",
      "Close your eyes and count to ten.",
      "Take advantage of the free therapy sessions",
      "Call your parents.",
      "Can you elaborate on your situation?",
      "I think that you should see a professional shrink.",
      "Have you spoke to anyone in your posse.",
      "You got this! You are a Posse Scholar!!!",
      "Despacito!!!",
      "Take it one step at a time."};

     public static String[] posseWords =
     {
      "posse","Kwesi","Emilia", "Teresa", "Molly", "Jaila", "Kevin",
      "Anderson","Jennifer", "Jeremie","three round interview process","Josue",
      "NY Posse", "Neshira", "Cyril", "Steven","Ekene","Itunu","Rosa", "Stephanie",
      "Victoria","Sultana","ATL"
     };
    public static String[] posseResponses=
    {
     "I think that we should have a group meeting",
     "Have you told your entire posse about this issue?",
     "I think that you should bring this  up in our group meeting.",
     "It will work out.",
     "I wish that I could help you more, but this is out of my hands",
     "Have you spoken to Tevin, your posse trainer?",
     "I am listening. Tell me more.",
     "Make the best decision for your Posse.",
     "We have our joint meeting with NY Posse next week.",
     "Keep me updated. I want to know if the Posse is storming, peforming, or norming. "
    };
    public static String[] friendsWords =
    {
     "friend","boyfriend","roommate"
    };
    public static String[] friendsResponses =
    {
     "What's going on?",
     "Call me for more advice",
     "Email me",
     "Remember that I am a mandated reporter.",
     "Do you want me to tell Ms. Kim or Ms. Judy?",
     "This milestone will pass.",
     "Are these meetings really helping you?",
     "How is this affecting you socially.",
     "That is not a healthy relationship. You should talk to someone.",
     "I don't like where this is going. Tell me more."
    };
    public static String[] extracurricularActivitiesWords =
    {
     "show","performance", "rebelle","extracurricular", "toxic","dance",
     "clubs"
    };
    public static String[] extracurricularActivitiesResponses =
    {
     "I think that you are taking on too much.",
     "Don't spread yourself too thin.",
     "Your posse and I will support you.",
     "When are your practices?",
     "Please share your schedule with me.",
     "You are amazing! You got this!!!",
     "I am so proud of how involved you are.",
     "You are doing great things on this campus.",
     "Give me more information",
     "Have you been able to balance your extracurriculars with dance"};
}
