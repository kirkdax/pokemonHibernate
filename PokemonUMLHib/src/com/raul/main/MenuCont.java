package com.raul.main;

import java.util.Scanner;

import com.raul.pokemon.Controller;

public class MenuCont {

	public static Scanner teclado = new Scanner(System.in);
	private static String usuario; // tipo de usuario: admin || user

	public static void main(String[] args) throws Exception {

		usuario = leerString("introduce el usuario:");

		Controller session = new Controller();		
		
		int menu = 1;

		while (menu != 0) {
			System.out.println("0. Salir");
			System.out.println("1. Consultar datos");

			if (usuario.equalsIgnoreCase("admin")) {
				System.out.println("2. Introducir datos");
				System.out.println("3. Modificar datos");
				System.out.println("4. Eliminar datos");
			}

			menu = Integer.parseInt(teclado.nextLine());

			switch (menu) {

			case 0:
				System.out.println("Hasta luego " + usuario + "!");

				// Cerramos los objetos.
				session.cerrarSesion();
				break;

			case 1:

				int menuConsultas = 1;

				while (menuConsultas != 0) {
					System.out.println("0. Volver al men�");
					System.out.println("1. Listado pokemon");
					System.out.println("2. Listado pokemon con dos tipos diferentes");
					System.out.println("3. Listado tipos");
					System.out.println("4. Listado movimientos");
					System.out.println("5. Movimiento m�s potente");
					System.out.println("6. Listado estad�sticas base");
//					System.out.println("7. Listado Pok�mon|Tipos");


					menuConsultas = Integer.parseInt(teclado.nextLine());

					switch (menuConsultas) {

					case 0:
						System.out.println(usuario + ", has vuelto al men�.");
						break;

					case 1:
						System.out.println(session.mostrarListadoPokemon());
						break;

					case 2:
						String tipo1 = leerString("Introduce el primer tipo:");
						String tipo2 = leerString("Introduce el segundo tipo:");

						try {
							System.out.println(session.mostrarListadoPokemonDobleTipo(tipo1, tipo2));
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;

					case 3:
						System.out.println(session.mostrarListadoTipos());
						break;

					case 4:
						System.out.println(session.mostrarListadoMovimientos());
						break;

					case 5:
						System.out.println(session.mostrarMovimientoMasPotente());
						break;
						
					case 6:
						System.out.println(session.mostrarListadoEstadisticas());
						break;
						
//					case 7:
//						int tipo = leerEntero("Introduce tipo:");
//						System.out.println(session.mostrarPokemonPorTipo(tipo));
//						break;

					default:
						System.out.println("Opci�n no v�lida");
						break;
					}

				}
				
				break;

			case 2:

				if (usuario.equalsIgnoreCase("admin")) {

					int menuInsertar = 1;

					while (menuInsertar != 0) {
						System.out.println("0. Volver al men�");
						System.out.println("1. Insertar pokemon");
						System.out.println("2. Insertar movimiento");
						System.out.println("3. Insertar tipo");
						System.out.println("4. Insertar estad�sticas de un Pok�mon");
						System.out.println("5. Insertar tipo a un Pok�mon");


						menuInsertar = Integer.parseInt(teclado.nextLine());

						switch (menuInsertar) {

						case 0:
							System.out.println(usuario + ", has vuelto al men�.");
							break;

						case 1:
							
							String nombrePok = leerString("Introduce el nombre del Pok�mon:");
							String nombreTipo = leerString("Introduce el tipo del Pok�mon:");
							int numPokedex = leerEntero("Introduce el n�mero de Pok�dex del Pok�mon:");
							double pesoPok = leerDouble("Introduce el peso del Pok�mon");
							double alturaPok = leerDouble("Introduce la altura del Pok�mon:");
							
							try {
								session.insertarPokemon(nombrePok, nombreTipo, numPokedex, pesoPok, alturaPok);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							
							break;

						case 2:
							String tipoMov = leerString("Introduce el tipo del movimiento:");

							String nombreMov = leerString("Introduce el nombre del movimiento");
							int potenciaMov = leerEntero("Introduce la potencia del movimiento");
							int precisionMov = leerEntero("Introduce la precisi�n del movimiento");
							String descripcionMov = leerString("Introduce la descripci�n del movimiento");
							int ppMov = leerEntero("Introduce los PP (Puntos de Poder) del movimiento");
							int prioridadMov = leerEntero("Introduce la prioridad del movimiento");

							try {
								session.insertarMovimiento(tipoMov, nombreMov, potenciaMov, precisionMov, descripcionMov, ppMov, prioridadMov);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

							break;

						case 3:
							nombreTipo = leerString("Introduce el nombre del tipo nuevo:");

							try {
								session.insertarTipo(nombreTipo);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							
							break;
							
						case 4: // Insertar estad�sticas de un Pok�mon
							String nombrePokemon = leerString("Introduce el nombre del pokemon:");
							int ps = leerEntero("Introduce los PS (puntos de salud) de " + nombrePokemon);
							int ataque = leerEntero("Introduce el valor ataque de " + nombrePokemon);
							int defensa = leerEntero("Introduce el valor la defensa de " + nombrePokemon);
							int especial = leerEntero("Introduce el valor especial de " + nombrePokemon);
							int velocidad = leerEntero("Introduce el valor de velocidad de " + nombrePokemon);

							try {
								session.insertarEstadisticasPokemon(nombrePokemon, ps, ataque, defensa, especial, velocidad);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 5:
							nombreTipo = leerString("Introduce el TIPO para insertarlo al pokemon:");
							nombrePokemon = leerString("Introduce el nombre del pokemon:");
							try {
								session.insertarTipoToPokemon(nombrePokemon, nombreTipo);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;


						default:
							System.out.println("Opci�n no v�lida");
							break;
						}

					}
				} else {
					System.out.println("Opci�n no v�lida");
				}

				break;

			case 3:

				if (usuario.equalsIgnoreCase("admin")) {

					int menuModif = 1;

					while (menuModif != 0) {
						System.out.println("0. Volver al men�");
						System.out.println("1. Modificar pokemon");
						System.out.println("2. Modificar movimiento");
						System.out.println("3. Modificar tipo");
						System.out.println("4. Modificar estad�sticas de un Pok�mon");

						menuModif = Integer.parseInt(teclado.nextLine());

						switch (menuModif) {

						case 0:
							System.out.println(usuario + ", has vuelto al men�.");
							break;

						case 1:
							
							String nombrePokemon = leerString("Introduce el nombre del Pok�mon:");
							String nuevoNombrePok = leerString("Introduce el NUEVO nombre que tendr� el Pok�mon:");
							double pesoPok = leerDouble("Introduce el NUEVO peso que tendr� el Pok�mon:");
							double alturaPok = leerDouble("Introduce la NUEVO altura que tendr� el Pok�mon:");
							
							try {
								session.modificarPokemon(nombrePokemon, nuevoNombrePok, pesoPok, alturaPok);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
		
							break;

						case 2:
							
							String nombreMov = leerString("Introduce el nombre del movimiento:");
							String nuevoNombreMov = leerString("Introduce el nombre NUEVO que tendr� el movimiento:");
							String nuevoTipo = leerString("Introduce el tipo NUEVO que tendr� el movimiento:");
							int potenciaMov = leerEntero("Introduce la potencia del movimiento");
							int precisionMov = leerEntero("Introduce la precisi�n del movimiento");
							String descripcionMov = leerString("Introduce la descripci�n del movimiento");
							int ppMov = leerEntero("Introduce los PP (Puntos de Poder) del movimiento");
							int prioridadMov = leerEntero("Introduce la prioridad del movimiento");
							
							try {
								session.modificarMovimiento(nombreMov, nuevoNombreMov, nuevoTipo, potenciaMov, precisionMov, descripcionMov, ppMov, prioridadMov);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							
							break;

						case 3:
							
							String nombreTipo = leerString("Introduce el nombre del tipo:");
							String nuevoNombreTipo = leerString("Introduce el NUEVO nombre que tendr� el tipo:");
							
							try {
								session.modificarTipo(nombreTipo, nuevoNombreTipo);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							
							break;

						case 4:
							nombrePokemon = leerString("Introduce el nombre del pokemon:");
							int ps = leerEntero("Introduce los PS (puntos de salud) de " + nombrePokemon);
							int ataque = leerEntero("Introduce el valor ataque de " + nombrePokemon);
							int defensa = leerEntero("Introduce el valor la defensa de " + nombrePokemon);
							int especial = leerEntero("Introduce el valor especial de " + nombrePokemon);
							int velocidad = leerEntero("Introduce el valor de velocidad de " + nombrePokemon);

							try {
								session.modificarEstadisticasPokemon(nombrePokemon, ps, ataque, defensa, especial, velocidad);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							
							break;

						default:
							System.out.println("Opci�n no v�lida");
							break;
						}

					}
				} else {
					System.out.println("Opci�n no v�lida");
				}

				break;

			case 4:

				if (usuario.equalsIgnoreCase("admin")) {

					int menuBorrar = 1;

					while (menuBorrar != 0) {
						System.out.println("0. Volver al men�");
						System.out.println("1. Eliminar pokemon");
						System.out.println("2. Eliminar movimiento");
						System.out.println("3. Eliminar tipo");
						System.out.println("4. Eliminar estad�sticas de un Pok�mon");
						System.out.println("5. Eliminar tipo a un Pok�mon");


						menuBorrar = Integer.parseInt(teclado.nextLine());

						switch (menuBorrar) {

						case 0:
							System.out.println(usuario + ", has vuelto al men�.");
							break;

						case 1:
							String nombrePokemon = leerString("Introduce el nombre del pokemon a eliminar:");
							try {
								session.eliminarPokemon(nombrePokemon);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;

						case 2:
							String nombreMovimiento = leerString("Introduce el nombre del movimiento a eliminar:");
							try {
								session.eliminarMovimiento(nombreMovimiento);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;

						case 3:
							String nombreTipo = leerString("Introduce el nombre del tipo a eliminar:");
							try {
								session.eliminarTipo(nombreTipo);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;

						case 4:
							nombrePokemon = leerString("Introduce el nombre del pokemon para eliminar sus estad�sticas:");
							try {
								session.eliminarEstadisticasPokemon(nombrePokemon);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 5:
							nombreTipo = leerString("Introduce el TIPO del pokemon a eliminar:");
							nombrePokemon = leerString("Introduce el nombre del pokemon:");
							try {
								session.eliminarTipoFromPokemon(nombrePokemon, nombreTipo);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;


						default:
							System.out.println("Opci�n no v�lida");
							break;
						}

					}
				} else {
					System.out.println("Opci�n no v�lida");
				}

				break;

			default:
				System.out.println("Opci�n no v�lida");
				break;
			}

		}

	} // fin main

	public static String leerString(String m) {
		String aux;

		System.out.println(m);
		aux = teclado.nextLine();

		return aux;
	}

	public static int leerEntero(String msg) {
		int resultado;

		System.out.println(msg);
		resultado = Integer.parseInt(teclado.nextLine());
		return resultado;
	}

	public static double leerDouble(String msg) {
		double resultado;

		System.out.println(msg);
		resultado = Double.parseDouble(teclado.nextLine());

		return resultado;
	}

}

//	https://github.com/kirkdax/pokemonHibernate