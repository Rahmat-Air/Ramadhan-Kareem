package com.example.islamdamai;


import com.example.islamdamai.model.Asma;

import java.util.ArrayList;

public class AsmaulHusna {

    private static String[] nomor2 = {
            "", "1", "2", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
            "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
            "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
            "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
            "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
            "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
            "90", "91", "92", "93", "94", "95", "96", "98", "98", "99"
    };

    private static String[] arab2 = {

            "الله", "الرحمن", "الرحيم", "الملك", "القدوس", "السلام", "المؤمن", "المهيمن", "العزيز", "الجبار",
            "المتكبر", "الخالق", "البارئ", "المصور", "الغفار", "القهار", "الوهاب", "الرزاق", "الفتاح", "العليم",
            "القابض", "الباسط", "الخافض", "الرافع", "المعز", "المذل", "السميع", "البصير", "الحكم", "العدل",
            "اللطيف", "الخبير", "الحليم", "العظيم", "الغفور", "الشكور", "العلى", "الكبير", "الحفيظ", "المقيت",
            "الحسيب", "الجليل", "الكريم", "الرقيب", "المجيب", "الواسع", "الحكيم", "الودود", "المجيد", "الباعث",
            "الشهيد", "الحق", "الوكيل", "القوى", "المتين", "الولى", "الحميد", "المحصى", "المبدئ", "المعيد",
            "المحيى", "المميت", "الحي", "القيوم", "الواجد", "الماجد", "الواحد", "الاحد", "الصمد", "القادر",
            "المقتدر", "المقدم", "المؤخر", "الأول", "الأخر", "الظاهر", "الباطن", "الوالي", "المتعالي", "البر",
            "التواب", "المنتقم", "العفو", "الرؤوف", "مالك الملك", "ذو الجلال و الإكرام", "المقسط", "الجامع", "الغنى", "المغنى",
            "المانع", "الضار", "النافع", "النور", "الهادئ", "البديع", "الباقي", "الوارث", "الرشيد", "الصبور"


    };

    private static String[] latin = {
            "Allah", "Ar-Rahman", "Ar-Rahiim", "Al-Malik", "Al-Quddus", "As-Salaam", "Al-Mu'min", "Al-Muhaimin", "Al-Aziiz", "Al-Jabbar",
            "Al-Mutakabbir", "Al-Khaliq", "Al-Baari", "Al-Mushawwir", "Al-Ghaffaar", "Al-Qahhar", "Al-Wahhaab", "Ar-Razzaaq", "Al-Fattah", "Al_'Aliim",
            "Al-Qaabidh", "Al-Baasith", "Al-Khaafidh", "Ar-Rafi'", "Al-Mu'izz", "Al-Mudzil", "As-Samii'", "Al-Bashiir", "Al-Hakam", "Al-'Adl",
            "Al-Lathiif", "Al-Khabiir", "Al-Haliim", "Al-'Azhiim", "Al-Ghafuur", "As-Syakuur", "Al-'Aliy", "Al-Kabiir", "Al-Hafizh", "Al-Muqiit",
            "Al-Hasiib", "Al-Jaliil", "Al-Kariim", "Ar-Raqiib", "Al-Mujiib", "Al-Waasi'", "Al-Hakim", "Al-Waduud", "Al-Majiid", "Al-Baa'its",
            "As-Syahiid", "Al-Haqq", "Al-Wakiil", "Al-Qawiyyu", "Al-Matiin", "Al-Waliyy", "Al-Hamid", "Al-Mushii", "Al-Mubdi'", "Al-Mu,iid",
            "Al-Muhyii", "Al-Mumiitu", "Al-Hayuu", "Al-Qayyum", "Al-Waajid", "Al-Maajid", "Al-Wahid", "Al-Ahad", "As-Shamad", "Al-Qaadir",
            "Al-Muqtadir", "Al-Muqaddim", "Al-Mu'akkhir", "Al-Awwal", "Al-Aakhir", "Az-Zhaahir", "Al-Baathin", "Al-Waali", "Al-Muta'aalii", "Al-Barru",
            "At-Tawwaab", "Al-Muntaqim", "Al-Afuww", "Ar-Ra'uuf", "Malikul Mulk", "Dzul Jalaali Wal Ikram", "Al-Muqsith", "Al-Jamii'", "Al-Ghaniyy", "Al-Mughnii",
            "Al-Maani", "Ad-Dhaar", "An-Nafii", "An-Nuur", "Al-Haadii", "Al-Badii'", "Al-Baaqii", "Al-Waarits", "Ar-Rasyiid", "As-Shabuur",


    };

    private static String[] arti = {
            "Allah", "Maha Pengasih", "Maha Penyayang", "Yang Maha Merajai / Memerintah", "Yang Maha Suci", "Yang Maha Memberi Kesejahteraan", "Yang Maha Memberi Keamanan", "Yang Maha Pemelihara", "Yang Maha Perkasa", "Yang Memiliki Mutlak Kegagahan",
            "Yang Maha Megah, Yang Memiliki Kebesaran", "Yang Maha Pencipta", "Yang Maha Melepaskan (Membuat, Membentuk, Menyeimbangkan)", "Yang Maha Membentuk Rupa (makhluknya)", "Yang Maha Pengampun", "Yang Maha Menundukan", "Yang Maha Pemberi Karunia", "Yang Maha Pemberi Rezeki", "Yang Maha Pembuka Rahmat", "Yang Maha Mengetahui (Memiliki Ilmu)",
            "Yang Maha Menyempitkan (makhluknya)", "Yang Maha Melapangkan (makhluknya)", "Yang Maha Merendahkan (makhluknya)", "Yang Maha Meninggikan (makhluknya)", "Yang Maha Memuliakan (makhluknya)", "Yang Maha Menghinakan (makhluknya)", "Yang Maha Mendengar", "Yang Maha Melihat", "Yang Maha Menetapkan", "Yang Maha Adil",
            "Yang Maha Lembut", "Yang Maha Mengenal", "Yang Maha Penyantun", "Allah Yang Maha Agung", "Allah Yang Maha Memberi Pengampunan", "Allah Yang Maha Pembalas Budi (Menghargai)", "Allah Yang Maha Tinggi", "Allah Yang Maha Besar", "Allah Yang Maha Memelihara", "Allah Yang Maha Pemberi Kecukupan",
            "Allah Yang Maha Membuat Perhitungan", "Allah Yang Maha Luhur", "Allah Yang Maha Pemurah", "Allah Yang Maha Mengawasi", "Allah Yang Maha Mengabulkan", "Allah Yang Maha Luas", "Allah Yang Maha Bijaksana", "Allah Yang Maha Mengasihi", "Allah Yang Maha Mulia", "Allah Yang Maha Membangkitkan",
            "Allah Yang Maha Menyaksikan", "Allah Yang Maha Benar", "Allah Yang Maha Memelihara", "Allah Yang Maha Kuat", "Allah Yang Maha Kokoh", "Allah Yang Maha Melindungi", "Allah Yang Maha Terpuji", "Allah Yang Maha Mengalkulasi (Menghitung Segala Sesuatu)", "Allah Yang Maha Memulai", "Allah Yang Maha Mengembalikan Kehidupan",
            "Allah Yang Maha Menghidupkan", "Allah Yang Maha Mematikan", "Allah Yang Maha Hidup", "Allah Yang Maha Mandiri", "Allah Yang Maha Penemu", "Allah Yang Maha Mulia", "Allah Yang Maha Tunggal", "Allah Yang Maha Esa", "Allah Yang Maha Dibutuhkan, Tempat Meminta", "Allah Yang Maha Menentukan, Maha Menyeimbangkan",
            "Allah Yang Maha Berkuasa", "Allah Yang Maha Mendahulukan", "Allah Yang Maha Mengakhirkan", "Allah Yang Maha Awal", "Allah Yang Maha Akhir", "Allah Yang Maha Nyata", "Allah Yang Maha Ghaib", "Allah Yang Maha Memerintah", "Allah Yang Maha Tinggi", "Allah Yang Maha Penderma (Maha Pemberi Kebajikan)",
            "Allah Yang Maha Penerima Tobat", "Allah Yang Maha Pemberi Balasan", "Allah Yang Maha Pemaaf", "Allah Yang Maha Pengasuh", "Allah Yang Maha Penguasa Kerajaan (Semesta)", "Allah Yang Maha Pemilik Kebesaran dan Kemuliaan", "Allah Yang Maha Pemberi Keadilan", "Allah Yang Maha Mengumpulkan", "Allah Yang Maha Kaya", "Allah Yang Maha Pemberi Kekayaan",
            "Allah Yang Maha Mencegah", "Allah Yang Maha Penimpa Kemudharatan", "Allah Yang Maha Memberi Manfaat", "Allah Yang Maha Bercahaya (Menerangi, Memberi Cahaya)", "Allah Yang Maha Pemberi Petunjuk", "Allah Yang Maha Pencipta Yang Tiada Bandingannya", "Allah Yang Maha Kekal", "Allah Yang Maha Pewaris", "Allah Yang Maha Pandai", "Allah Yang Maha Sabar"


    };


    static ArrayList<Asma> getListData() {
        ArrayList<Asma> list = new ArrayList<>();
        for (int position = 0; position < nomor2.length; position++) {
            Asma asma = new Asma();
            asma.setNomor(nomor2[position]);
            asma.setArab(arab2[position]);
            asma.setLatin(latin[position]);
            asma.setArti(arti[position]);
            list.add(asma);
        }
        return list;
    }
}

