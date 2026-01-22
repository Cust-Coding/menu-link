import i18n from "i18next";
import { initReactI18next } from "react-i18next";
import LanguageDetector from "i18next-browser-languagedetector";

import enTranslation from "@/locales/en/translation.json";
import ptTranslation from "@/locales/pt/ translation.json";

export interface TranslationKeys{
    features: string;
    pricing: string;
    about: string;
    support: string;
    contact: string;
    login: string;
    signup: string;
}

const resources: Record<string, { translation: TranslationKeys }> = {
  en: { translation: enTranslation as TranslationKeys },
  pt: { translation: ptTranslation as TranslationKeys },
};


i18n
  .use(LanguageDetector)
  .use(initReactI18next)
  .init({
    resources,
    fallbackLng: "en",
    interpolation: { escapeValue: false },
  });

export default i18n;