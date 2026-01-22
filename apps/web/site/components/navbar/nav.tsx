'use client'; 

import { useTranslation } from "react-i18next";
import type {TranslationKeys} from "../i18n/i18n"

export default function Nav() {
  const { t } = useTranslation();


  const menuKeys: Array<keyof TranslationKeys> = [
    "features",
    "pricing",
    "about",
    "contact",
  ];

  return (
    <nav className="flex space-x-6 p-4 bg-gray-100">
      {menuKeys.map((key) => (
        <a
          key={String(key)}
          href={`#${key}`}
          className="text-gray-700 hover:text-green-600"
        >
          {t(key)} 
        </a>
      ))}
    </nav>
  );
}
