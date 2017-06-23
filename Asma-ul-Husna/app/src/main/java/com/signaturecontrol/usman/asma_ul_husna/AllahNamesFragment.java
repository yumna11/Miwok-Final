package com.signaturecontrol.usman.asma_ul_husna;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllahNamesFragment extends Fragment {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };




    public AllahNamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
                View rootView = inflater.inflate(R.layout.list_view, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        // Create and setup the {@link AudioManager} to request audio focus
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("The Name of Allah","الله کا ذاتی نام","اَللهُ",R.raw.allah));

        words.add(new Word("The Extremely Merciful","نہایت مہربان","الرَّحْمَنُ",R.raw.ar_rehman));
        words.add(new Word("The Infinitely Merciful","بہت رحم کرنے والآ","الرَّحِيْمُ",R.raw.ar_rahim));
        words.add(new Word("The [True] King","بادشاہ","الْمَلِكُ",R.raw.al_malik));
        words.add(new Word("The Perfectly Pure","نہایت پاک","الْقُدُّوْسُ",R.raw.al_quddus));
        words.add(new Word("The Giver Of Peace","سلآمتی دینے والآ","السَّلَآمُ",R.raw.as_salaam));
        words.add(new Word("The Bestower of safety","امن دینے والآ","الْمُؤْمِنُ",R.raw.al_mumin));
        words.add(new Word("The Overseer","نگہبان","الْمُهَيْمِنُ",R.raw.al_muhaimin));
        words.add(new Word("The Exalted in Might","غالب","الْعَزِيْزُ",R.raw.al_aziz));
        words.add(new Word("The Compeller","اپنی مرضی چلآنے والآ","الْجَبَّارُ",R.raw.al_jabbar));
        words.add(new Word("The Superior","بے حد بڑائ والآ","الْمُتَكَبِّرُُ",R.raw.al_mutakabir));
        words.add(new Word("The Creator","پیدا کرنے والآ","الْخَالِقُ",R.raw.al_khaliq));
        words.add(new Word("The Inventor","پیدا کرنے والآ","الْبَارِئُ",R.raw.al_baari));
        words.add(new Word("The Fashioner","صورت بنانے والآ","الْمُصَوِّرُ",R.raw.al_mushawwir));
        words.add(new Word("The Perpetual Forgiver","بہت بخشنے والآ","الْغَفَّارُ",R.raw.al_ghaffar));
        words.add(new Word("The Prevailing","نہایت زبردست","الْقَهَّارُ",R.raw.al_qahhaar));
        words.add(new Word("The Liberal Bestower","بہت زیادہ دینے والآ ","الْوَهَّابُ",R.raw.al_wahaab));
        words.add(new Word("The continual provider","بہت زیازہ رزق دینے والآ ","الرَّزَّاقُ",R.raw.ar_razzaaq));
        words.add(new Word("The Opener","كهولنے والا","الْفَتَّاحُ",R.raw.al_fattaah));

        words.add(new Word("The Ever-Knowing","سب کچھ جانیے والآ","الْعَلِيْمُ",R.raw.al_aliim));
        words.add(new Word("The One who constricts","تنگی کرنے والآ","الْقَابِضُ",R.raw.al_qaabidh));
        words.add(new Word("The Expander","کشادگی کرنے والآ","الْبَاسِطُ",R.raw.al_baasith));

        words.add(new Word("The Abaser","پست کرنے والا","الْخَافِضُ",R.raw.al_khafidh));
        words.add(new Word("The Exalter","بلند کرنے والا","الرَّافِعُ",R.raw.ar_raafi));
        words.add(new Word("The Giver of Honour","عزت دینے والا","الْمُعِزُّ",R.raw.al_muiz));
        words.add(new Word("The Giver of Dishonour","ذلیل کرنے والا","الْمُذِلُّ",R.raw.al_muzil));
        words.add(new Word("The Ever-Listening","سب کچھ سننے والآ","السَّمِيْعُ",R.raw.as_sami));
        words.add(new Word("The Ever-Seeing","سب کچھ  دیکھنے والآ  ","الْبَصِيْرُ",R.raw.al_bashir));
        words.add(new Word("The True Judge","فیصلہ کرنے والآ","الْحَكَمُ",R.raw.al_hakam));
        words.add(new Word("The Utterly Just","انصاف کرنے والا","الْعَدْلُ",R.raw.al_adl));

        words.add(new Word("The Subtle","نرمی کرنے والآ","اللَّطِيْفُ",R.raw.al_lathiif));
        words.add(new Word("The Ever-Acquainted","سب خبر رکھنے والآ","الْخَبِيْرُ",R.raw.al_khabir));
        words.add(new Word("The Ever-Forbearing","نہایت بردبار","الْحَلِيْمُ",R.raw.al_halim));
        words.add(new Word("The Most Great","سب سے بڑا","الْعَظِيْمُ",R.raw.al_adzhim));
        words.add(new Word("The Most Forgiving","بے حد بخشنے والآ","الْغَفُوْرُ",R.raw.al_ghafoor));
        words.add(new Word("The Most Appreciative","نہایت قدردان","الشَّكُوْرُ",R.raw.ash_shakoor));
        words.add(new Word("The Sublimely-Exalted","بلندی والا","الْعَلِيُّ",R.raw.al_aliy));
        words.add(new Word("The Grand","سب سے بڑا","الْكَبِيْرُ",R.raw.al_kabeer));
        words.add(new Word("The Ever-Preserving","بہت حفاظت کرنے والآ","الْحَفِيْظُ",R.raw.al_hafeez));
        words.add(new Word("The Sustainer","روزی دینے والآ","الْمُقِيْتُ",R.raw.al_muqeet));
        words.add(new Word("The Account-Taker","حساب لینے والآ","الْحَسِيْبُ",R.raw.al_haseeb));
        words.add(new Word("The Glorious","بزرگی والا","الْجَلِيْلُ",R.raw.al_jaleel));

        words.add(new Word("The Honourable","بڑا بزرگ","الْكَرِيْمُ",R.raw.al_kareem));
        words.add(new Word("The Ever Observing","نگہبان","الرَّقِيْب",R.raw.ar_raqeeb));
        words.add(new Word("The Supreme Answerer","دعا قبول کرنے والآ","الْمُجِيْبُ",R.raw.al_mujeeb));
        words.add(new Word("The Vast","کشائش والا","الْوَاسِعُ",R.raw.al_waasi));
        words.add(new Word("The Perfectly Wise","حکمت والآ","الْحَكِيْمُ",R.raw.al_hakeem));
        words.add(new Word("The Most Loving","نہایت محبت کرنے والآ","الْوَدُوْدُ",R.raw.al_wadood));
        words.add(new Word("The Honourable","نہایت بزرگی کرنے والآ","الْمَجِيْدُ",R.raw.al_majeed));
        words.add(new Word("The Infuser of New Life","اٹھانے والا","الْبَاعِثُ",R.raw.al_bais));

        words.add(new Word("The Witness","گواہ","الشَّهِيْدُ",R.raw.as_shaheed));
        words.add(new Word("The Truth","سچا اور ثابت","الْحَقُّ",R.raw.al_haq));
        words.add(new Word("The Disposer of affairs","کارساز","الْوَكَيْلُ",R.raw.al_waqeel));
        words.add(new Word("The Supremely Strong","نہایت طاقتور","الْقَوِىُّ",R.raw.al_qawi));
        words.add(new Word("The Extremely Firm","نہایت مضبوط","الْمَتِيْنُ",R.raw.mateen));
        words.add(new Word("The Protecting Friend","دوست - مددگار","الْوَلِىُّ",R.raw.wali));
        words.add(new Word("The Infinitely Praiseworthy","تعریف کیا ہوا","الْحَمِيْدُ",R.raw.hameed));
        words.add(new Word("The All-Enumerating One","گننے والا","الْمُحْصِي",R.raw.mohsi));
        words.add(new Word("The Originator","پہلی بار پیدا کرنے والا","الْمُبْدِئُ",R.raw.mubid));
        words.add(new Word("The Restorer","دوبارہ پیدا کرنے والا","الْمُعِيدُ",R.raw.mueed));
        words.add(new Word("The Maintainer of life","زندہ کرنے والا","الْمُحْيِي",R.raw.muyeh));
        words.add(new Word("The Inflictor of Death","مارنے والا","اَلْمُمِيتُ",R.raw.al_mumeet));

        words.add(new Word("The Ever-Living","خود زندہ اور سب کو زندگی دینے والا","الْحَىُّ",R.raw.al_hayy));
        words.add(new Word("The Self-Subsisting and The Sustainer","خود قائم اور ساری کائنات کو قائم رکھنے والا","الْقَيُّوْمُ",R.raw.al_qayyoom));
        words.add(new Word("The [Only] One","اکیلا - یکتاویگانہ","الْوَاجِدُ",R.raw.al_wajid));

        words.add(new Word("The All-Noble One","عزت والا","الْمَاجِدُ"));
        words.add(new Word("The Only One","اکیلا","الْواحِدُ",R.raw.al_wahid));
        words.add(new Word("The Single"," ایک - اکیلا","الْاَحَدُ"));
        words.add(new Word("The Eternal Refuge","بےنیاز","الصَّمَدُ",R.raw.al_samad));

        words.add(new Word("The Capable","قدرت رکھنے والا","الْقَادِرُ",R.raw.al_qadir));
        words.add(new Word("The Perfect in Ability","مکمل قدرت رکھنے والا","الْمُقْتَدِرُ",R.raw.al_muqtadir));
        words.add(new Word("The One who brings forward","آگے کرنے والا","الْمُقَدِّمُ",R.raw.al_muqaddim));
        words.add(new Word("The One who defers","پیچھے کرنے والا","الْمُؤَخِّرُ",R.raw.al_muakhkir));
        words.add(new Word("The First","سب سے پہلے","الْاَوَّلُ",R.raw.al_awwal));
        words.add(new Word("The Last","سب کے بعد","الْآخِرُ",R.raw.al_aakhir));

        words.add(new Word("The Ascendant","سب سے ظاہر","الظَّاهِرُ",R.raw.az_zaahir));
        words.add(new Word("The Unapparent","سب سے پوشیدہ","الْبَاطِنُ",R.raw.al_baatin));
        words.add(new Word("The Holder of Supreme Authority","مالک","الْوَالِي",R.raw.wali));

        words.add(new Word("The Extremely Exalted","انتہائ بلند","الْمُتَعَالِي",R.raw.al_mutaaalee));
        words.add(new Word("The Beneficient","بھلائ کرنے والا ","الْبَرُّ",R.raw.al_barr));
        words.add(new Word("The Ever Accepting of repentance","بہت توبہ قبول کرنے والا","التَّوَّابُ",R.raw.at_tawwaab));

        words.add(new Word("The Retaliator","بدلہ لینے والا","الْمُنْتَقِمُ",R.raw.al_muntaqim));
        words.add(new Word("The Ever-Pardoning","بہت معاف کرنے والا","الْعَفُوُّ",R.raw.al_afuww));
        words.add(new Word("The Most Affectionate","بہت شفقت کرنے والا","الرَّءُوْفُ",R.raw.ar_raoof));

        words.add(new Word("The Eternal Possessor of Sovereignty","بادشاہی کا مالک","مَالِكُ الْمُلْكِ"));
        words.add(new Word("The Possessor of Majesty and Honour","جلال اور انعام والا","ذُوالْجَلاَلِ وَالإكْرَامِ",R.raw.dhul_jalaali_wal_ikraam));
        words.add(new Word("The Just One","انصاف کرنے والا","الْمُقْسِطُ",R.raw.al_muqsit));
        words.add(new Word("The Assembler of Scattered Creations","اکٹھا کرنے والا","الْجَامِعُ",R.raw.al_jaami));

        words.add(new Word("The Independent","سب سے بے پرواہ","الْغَنِىُّ",R.raw.al_ghaniyy));
        words.add(new Word("The Bestower of Sufficiency","بے پرواہ کرنے والا ","الْمُغْنِي",R.raw.al_mughnee));
        words.add(new Word("The Preventer","روکنے والا","اَلْمَانِعُ",R.raw.al_maani));
        words.add(new Word("The Distressor","نقصان پہنچانے والا","الضَّارَّ",R.raw.ad_daar));
        words.add(new Word("The Bestower of Benefits","نفع پہنچانے والا","النَّافِعُ",R.raw.an_naafi));
        words.add(new Word("The Prime Light","روشن کرنے والا","النُّورُ",R.raw.an_noor));
        words.add(new Word("The Provider of Guidance","ہدایت دینے والا","الْهَادِي",R.raw.al_haadee));
        words.add(new Word("The Unique One","نئ طرح پیدا کرنے والا","الْبَدِيعُ",R.raw.al_badee));
        words.add(new Word("The Ever Surviving One","باقی رہنے والا","اَلْبَاقِي",R.raw.al_baaqee));
        words.add(new Word("The Eternal Inheritor","سب کا وارث","الْوَارِثُ",R.raw.al_waarith));
        words.add(new Word("The Guide to Path of Rectitude","نیک راہ بتانے والا","الرَّشِيدُ",R.raw.ar_rasheed));
        words.add(new Word("The Extensively Enduring One","صبر کرنے والا","الصَّبُورُ",R.raw.as_saboor));

        WordAdapter list = new WordAdapter(getActivity(),R.layout.list_item_view,words);

        listView.setAdapter(list);
        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                if(word.getAudioID() != 0)
                {
                    // Release the media player if it currently exists because we are about to
                    // play a different sound file
                    releaseMediaPlayer();
                    // Request audio focus so in order to play the audio file. The app needs to play a
                    // short audio file, so we will request audio focus with a short amount of time
                    // with AUDIOFOCUS_GAIN_TRANSIENT.
                    int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // We have audio focus now.
                        // Create and setup the {@link MediaPlayer} for the audio resource associated
                        // with the current word
                        mediaPlayer = MediaPlayer.create(getActivity(), word.getAudioID());

                        // Start the audio file
                        mediaPlayer.start();

                        // Setup a listener on the media player, so that we can stop and release the
                        // media player once the sound has finished playing.
                        mediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
            }
        });


        return rootView;
    }
    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
           audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }


}
