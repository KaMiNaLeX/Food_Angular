import {Dish} from "./dish";

export class Order {
  id: number;
  clientId: number;
  sum: number;
  timeOrder: Date;
  dishesDtoList: Array<Dish>;
}
