package lesson20240703;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class CityWithCountryAndContinent extends City {
        private String district;
        private String countryName;
        private String continent;

        @Override
        public String toString() {
            return "CityWithCountryAndContinent{" +
                    "id=" + this.getId() +
                    ", name='" + this.getName() + '\'' +
                    ", countryCode='" + this.getCountryCode() + '\'' +
                    ", population=" + this.getPopulation()  +
                    ", district='" + district + '\'' +
                    ", countryName='" + countryName + '\'' +
                    ", continent='" + continent + '\'' +
                    '}';
        }
    }

