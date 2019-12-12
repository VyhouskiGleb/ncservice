import {Movie} from "./movie";

export interface Lib {
  id: number,
  userId: number,
  utcEnd: number;
  status: number;
  movie: Movie;
}
